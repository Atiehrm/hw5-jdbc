package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtilities {
    private Connection connection = null;

    public DatabaseUtilities() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw5"
                , "root", "root");
    }

    public Connection getConnection() {
        return connection;
    }

    public void resetEmployeeDataBase() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQueryDrop = String.format("DROP TABLE employee");
            statement.executeUpdate(sqlQueryDrop);
        }
    }

    public void resetWorkUnitDataBase() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQueryDrop = String.format("DROP TABLE workunit");
            String sqlQueryCreate = String.format("CREATE TABLE `workunit` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` varchar(45) NOT NULL,\n" +
                    "  `phone` int DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");");

            statement.executeUpdate(sqlQueryDrop);
            statement.executeUpdate(sqlQueryCreate);
        }
    }


    public void createEmployeeDataBase() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sqlQueryCreate = String.format("CREATE TABLE `employee` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name` varchar(45) NOT NULL,\n" +
                    "  `last_name` varchar(45) NOT NULL,\n" +
                    "  `employee_number` int NOT NULL,\n" +
                    "  `birth_day` date DEFAULT NULL,\n" +
                    "  `workunit_id` int NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  KEY `workunit_idx` (`workunit_id`),\n" +
                    "  CONSTRAINT `FK_EMPLOYEE_WORKUNIT` FOREIGN KEY (`workunit_id`) REFERENCES `workunit` (`id`)\n" +
                    ");");
            statement.executeUpdate(sqlQueryCreate);
        }
    }
}
