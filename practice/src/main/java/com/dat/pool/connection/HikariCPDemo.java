package com.dat.pool.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCPDemo {
    private static HikariDataSource dataSource = null;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3307/empdb?useSSL=false");
        config.setUsername("root");
        config.setPassword("12345678");
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tblemployee");
            while (resultSet.next()) {
                System.out.println("empId:" + resultSet.getInt("empId"));
                System.out.println("empName:" + resultSet.getString("empName"));
                System.out.println("dob:" + resultSet.getDate("dob"));
                System.out.println("designation:" + resultSet.getString("designation"));
            }
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
