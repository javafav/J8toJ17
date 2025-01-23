package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class MySqlMusicDB {
    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";


    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog(
                null, "Enter DB Username");

        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf,
                "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);

        final char[] password =
                (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;

        var dataSource = new MysqlDataSource();
        dataSource.setURL(CONN_STRING);
        dataSource.setServerName("localhost");
       dataSource.setPort(3306);
        dataSource.setDatabaseName("music");
dataSource.setUser(userName);
dataSource.setPassword(String.valueOf(password));

//        try(Connection connection = DriverManager.getConnection(
//                CONN_STRING, userName, String.valueOf(password)))
        try (Connection connection = dataSource.getConnection()  ) {
            System.out.println("Success!! Connection made to music database");
            Arrays.fill(password, ' ');
        //    System.out.println(    connection.getSchema() );
            System.out.println(connection.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
