package com.dat.pool.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCP2Demo {
    private static BasicDataSource dataSource = null;

    private static final String DB_URL = "jdbc:mysql://localhost:3307/empdb?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try(Connection connection = DBCP2Demo.getConnection()) {
            con = connection;
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tblemployee");
            while (resultSet.next()) {
                System.out.println("empId:" + resultSet.getInt("empId"));
                System.out.println("empName:" + resultSet.getString("empName"));
                System.out.println("dob:" + resultSet.getDate("dob"));
                System.out.println("designation:" + resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
