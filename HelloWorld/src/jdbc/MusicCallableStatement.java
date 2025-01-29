package jdbc;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

import static jdbc.PreparedStatementDemo.printRecords;

public class MusicCallableStatement {

    private static final int ARTIST_COLUMN = 0;
    private static final int ALBUM_COLUMN = 1;
    private static final int SONG_COLUMN = 3;
    private static final int TRACK_COLUMN = 2;


    public static void main(String[] args) {
        Map<String, Map<String, String>> albums = null;
        try(var lines = Files.lines(Path.of("files/NewAlbums.csv"))) {
            albums = lines.map(s -> s.split(","))
                    .collect(Collectors.groupingBy(s -> s[ARTIST_COLUMN],

                            Collectors.groupingBy(s -> s[ALBUM_COLUMN],
                                    Collectors.mapping(s -> s[SONG_COLUMN],
                                            Collectors.joining(
                                                    "\",\"",
                                                    "[\"",
                                                    "\"]"
                                            )))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        albums.forEach((artist, artistAlbums) -> {
            artistAlbums.forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });
        });


        var datasource = new MysqlDataSource();

        datasource.setServerName("localhost");
        datasource.setPort(3306);
        datasource.setDatabaseName("music");


        try (Connection conn = datasource.getConnection(System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"))) {

      /*      CallableStatement cs = conn.prepareCall(
                    "CALL music.addAlbumInOutCounts(?,?,?,?)");

            albums.forEach((artist, albumMap) -> {
                albumMap.forEach((album, songs) -> {
                    try{
                        cs.setString(1, artist);
                        cs.setString(2, album);
                        cs.setString(3, songs);
                        cs.setInt(4,0); // must initialize the INOUT variable otherwise , it's set to NULL and give wrong calculations
                        cs.registerOutParameter(4, Types.INTEGER);
                        cs.execute();
                        System.out.printf("%d songs were added for %s%n", cs.getInt(4), album);
                    }catch (SQLException e){
                        System.err.println(e.getErrorCode() + " " + e.getMessage());
                    }
                });
            });  */

            String sql = "SELECT * FROM music.albumview WHERE artist_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Bob Dylan");
            ResultSet rs = ps.executeQuery();
            printRecords(rs);
            CallableStatement csf = (CallableStatement) conn.prepareCall(
                    "{ ? = CALL music.calcA lbumLength(?) } " );

csf.registerOutParameter(1, Types.DOUBLE);
albums.forEach((artist, albumMap) -> {
    albumMap.keySet().forEach((albumName) -> {
        try{
            csf.setString(2, albumName);
            csf.execute();
            double result = csf.getDouble(1);
            System.out.printf("Length of %s is %.1f%n", albumName, result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });
});


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
