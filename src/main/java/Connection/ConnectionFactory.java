package main.java.Connection;

import java.sql.*;

public class ConnectionFactory {

    private String url = "jdbc:postgresql://ec2-23-21-220-48.compute-1.amazonaws.com:5432/dcr9jm617pikhf?user=huoagoeyxoavlj&password=34399d5c7942b38c22d3dcbd6783f2f5490c02b437ff545cf390cfb05279511e&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
