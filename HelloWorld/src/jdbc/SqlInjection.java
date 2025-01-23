package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class SqlInjection {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            props.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var datasource = new MysqlDataSource();
        datasource.setServerName(props.getProperty("serverName"));
        datasource.setPort(Integer.parseInt(props.getProperty("port")));
        datasource.setDatabaseName(props.getProperty("databaseName"));
        try (var connection = datasource.getConnection(
                props.getProperty("user"),
                System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement()) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Plz enter an artist Id: ");
            String artistId = scanner.nextLine();
            String query = "SELECT * FROM music.artists WHERE artist_id = %s".formatted(artistId);  // if user enter like 8 or artist_id = 9 both results are included
                                                                                                   //

            //System.out.println("Success!");
            ResultSet resultSet = statement.executeQuery(query);
            var meta = resultSet.getMetaData();

//            for (int i = 1; i <= meta.getColumnCount(); i++) {  //get meta data about query
//                System.out.printf("%d %s %s%n",
//                        i,
//                        meta.getColumnName(i)
//                        , meta.getColumnTypeName(i));
//            }


            System.out.println("======================");

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
            }
            System.out.println();
            while (resultSet.next()) {
//                System.out.printf("%d %s %s %n",
//                        resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title")
//                );

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

