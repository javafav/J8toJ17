package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import finalmodifier.PersonRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JDBCChallenges {
    private static final String USE_SCHEMA = "USE storefront";
    private static final int MYSQL_DB_NOT_FOUND = 1049;

    public static void main(String[] args) {
        var datasource = new MysqlDataSource();
        datasource.setServerName("localhost");
        datasource.setPort(3306);
        datasource.setUser(System.getenv("MYSQL_USER"));
        datasource.setPassword(System.getenv("MYSQL_PASS"));

        try (Connection conn = datasource.getConnection()) {
            var metadata = conn.getMetaData();
            System.out.println(metadata.getSQLStateType());
            if (!checkSchema(conn)) {
                System.out.println("storefront schema does not exists!");
                setupSchema(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private static boolean checkSchema(Connection conn) throws SQLException {
        try (Statement statement = conn.createStatement()) {
            // statement.execute(USE_SCHEMA);
            addOrder(conn, new String[]{"shoes", "socks", "key board"});
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Sql state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            if (conn.getMetaData().getDatabaseProductName().equals("MySQL")
                    && e.getErrorCode() == MYSQL_DB_NOT_FOUND) {
                return false;
            } else throw e;
        }
        return true;
    }


    private static void setupSchema(Connection conn) throws SQLException {
        String createSchema = "CREATE SCHEMA storefront";
        String createOrder = """
                CREATE TABLE storefront.order (
                order_id int NOT NULL AUTO_INCREMENT,
                order_date DATETIME NOT NULL,
                PRIMARY KEY (order_id)
                )""";

        String createOrderDetails = """
                CREATE TABLE storefront.order_details (
                order_detail_id int NOT NULL AUTO_INCREMENT,
                item_description text,
                order_id int DEFAULT NULL,
                PRIMARY KEY (order_detail_id),
                KEY FK_ORDERID (order_id),
                CONSTRAINT FK_ORDERID FOREIGN KEY (order_id)
                REFERENCES storefront.order (order_id) ON DELETE CASCADE
                )""";

        try (Statement statement = conn.createStatement()) {
            System.out.println("Creating storefront Database");
            statement.execute(createSchema);
            if (checkSchema(conn)) {
                statement.execute(createOrder);
                System.out.println("Successfully Created Order Table");
                statement.execute(createOrderDetails);
                System.out.println("Successfully Create Order Details Table ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int addOrder(Connection conn, String[] items) throws SQLException {
        int orderId = -1;

        String insertOrder = "INSERT INTO storefront.order (order_date) VALUES ('%s')";
        String insertDetail = "INSERT INTO storefront.order_details " +
                "(order_id, item_description)  VALUES (%d, %s)";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String orderDateTime = LocalDateTime.now().format(dtf);
        System.out.println(orderDateTime);
        String formattedString = insertOrder.formatted(orderDateTime);
        System.out.println(formattedString);

        String insertOrderAlternative = "INSERT INTO storefront.order (order_date) " +
                "VALUES ('%1$tF %1$tT')";
        System.out.println(insertOrderAlternative.formatted(LocalDateTime.now()));

        try(Statement statement = conn.createStatement()){
            conn.setAutoCommit(false);
            int inserts = statement.executeUpdate(formattedString,
                    Statement.RETURN_GENERATED_KEYS);

            if(inserts == 1){
                var rs = statement.getGeneratedKeys();
                if(rs.next()){
                    orderId = rs.getInt(1);

                }
            }

            int count = 0;
            for(var item : items){
                formattedString = insertDetail.formatted(orderId,
                        statement.enquoteLiteral(item));
                inserts = statement.executeUpdate(formattedString);
                count += inserts;
            }


            if(count != items.length){
                orderId = -1;
                System.out.println("Numbers of records doesn't equals items received");
                conn.rollback();
            }else {
                conn.commit();
            }

            conn.setAutoCommit(true);
        }catch (SQLException e){
            conn.rollback();
            throw new RuntimeException();
        }



        return orderId;

    }

    private static void deleteOrder(Connection conn, int orderId) throws SQLException {

        String deleteOrder = "DELETE FROM %s where order_id=%d";
        String parentQuery = deleteOrder.formatted("storefront.order", orderId);
        String childQuery = deleteOrder.formatted("storefront.order_details",
                orderId);

        try (Statement statement = conn.createStatement()) {
            conn.setAutoCommit(false);
            int deletedRecords = statement.executeUpdate(childQuery);
            System.out.printf("%d child records deleted%n", deletedRecords);
            deletedRecords = statement.executeUpdate(parentQuery);
            if (deletedRecords == 1) {
                conn.commit();
                System.out.printf("Order %d was successfully deleted%n", orderId);
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
