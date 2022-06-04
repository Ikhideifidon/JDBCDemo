package com.github.ikhideifidon.jdbcdemo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JDBCDriver {
    private static final Logger logger = Logger.getLogger(JDBCDriver.class.getCanonicalName());
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/contact_address";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "#@^%B1g+-ret";

    public static void getConnection() {
        Statement statement;
        ResultSet resultSet;

        try {
            Class.forName(DB_DRIVER);
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException classNotFoundException) {
            logger.log(Level.SEVERE, classNotFoundException.getMessage());
            classNotFoundException.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            System.out.println("Connection Established");
            statement = connection.createStatement();
            String query = "SELECT * FROM REGISTER";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (SQLException sqlException) {
            logger.log(Level.SEVERE, sqlException.getMessage(), sqlException.getSQLState());
            sqlException.printStackTrace();
        }
    }

}
