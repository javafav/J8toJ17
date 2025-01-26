package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreparedStatementDemo {
    private static final String ARTIST_INSERT =
            "INSERT INTO music.artists (artist_name) VALUES (?)";
    private static final String ALBUM_INSERT =
            "INSERT INTO music.albums (artist_id, album_name) VALUES (?, ?)";
    private static final String SONG_INSERT =
            "INSERT INTO music.songs (album_id, tracK_number, song_title) VALUES (?, ? ,?)";


    public static void main(String[] args) {
        var datasource = new MysqlDataSource();

        datasource.setServerName("localhost");
        datasource.setPort(3306);
        datasource.setDatabaseName("music");
        try {
            datasource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (Connection conn = datasource.getConnection(System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"))) {
            addDataFromFile(conn);
            String sql = "SELECT * FROM music.albumview WHERE artist_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Bob Dylan");
            ResultSet rs = ps.executeQuery();
            printRecords(rs);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean printRecords(ResultSet resultSet) throws SQLException {
        boolean foundData = false;

        var meta = resultSet.getMetaData();

        System.out.println("======================");

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
        }
        System.out.println();
        while (resultSet.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
            foundData = true;

        }
        return foundData;
    }

    private static int addArtist(PreparedStatement ps, Connection conn,
                                 String artistName) throws SQLException {
        int artistId = -1;
        ps.setString(1, artistName);
        int insertedCount = ps.executeUpdate();
        if (insertedCount > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                artistId = generatedKeys.getInt(1);
                System.out.println("Auto_increment ID: " + artistId);

            }
        }
        return artistId;
    }

    private static int addAlbum(PreparedStatement ps, Connection conn, int artistId,
                                String albumName) throws SQLException {
        int albumId = -1;
        ps.setInt(1, artistId);
        ps.setString(2, albumName);
        int insertedCount = ps.executeUpdate();
        if (insertedCount > 0) {
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                albumId = generatedKeys.getInt(1);
                System.out.println("Auto_increment ID: " + albumId);

            }
        }
        return albumId;
    }

    private static void addSong(PreparedStatement ps, Connection conn, int albumId,
                               int trackNo, String songTitle) throws SQLException {

        ps.setInt(1, albumId);
        ps.setInt(2, trackNo);
        ps.setString(3, songTitle);
        ps.addBatch();




    }

    private static void addDataFromFile(Connection conn)
            throws SQLException {
        List<String> records = new ArrayList<>();
        try {
            records = Files.readAllLines(Path.of("files/NewAlbums.csv"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String lastAlbum = null;
        String lastArtist = null;
        int artistId = -1;
        int albumId = -1;
        try (PreparedStatement psArtist = conn.prepareStatement(ARTIST_INSERT,
                Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psAlbum = conn.prepareStatement(ALBUM_INSERT,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psSong = conn.prepareStatement(SONG_INSERT,
                     Statement.RETURN_GENERATED_KEYS)
        ) {

            conn.setAutoCommit(false);
            for(String record: records){
                String[] columns = record.split(",");
                if(lastArtist == null ||  !lastArtist.equals(columns[0])){
                    lastArtist = columns[0];
                    artistId = addArtist(psArtist, conn, lastArtist);
                }

                if(lastAlbum == null || !lastAlbum.equals(columns[1])){
                    lastAlbum = columns[1];
                    albumId = addAlbum(psAlbum, conn, artistId, lastAlbum);
                }

                addSong(psSong, conn, albumId, Integer.parseInt(columns[2]), columns[3]);

            }


            int[] inserts = psSong.executeBatch();
            int totalInserts = Arrays.stream(inserts).sum();
            System.out.printf("%d song records added %n", inserts.length);
            conn.commit();
            conn.setAutoCommit(true);


        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
    }
}
