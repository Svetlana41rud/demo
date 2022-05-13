package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqliteAuthService {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:chatdb.db");) {
            createTable(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createTable(Connection connection) throws SQLException {
        try (final PreparedStatement statement = connection.prepareStatement("" +
                "CREATE TABLE IF NOT EXISTS user (" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT" +
                "                          NOT NULL" +
                "                          UNIQUE," +
                "    login    VARCHAR (32) UNIQUE" +
                "                          NOT NULL," +
                "    password VARCHAR (32) NOT NULL," +
                "    nickname VARCHAR (32) UNIQUE" +
                "                          NOT NULL" +
                ")")) {
            statement.executeUpdate();
        }
    }
}
