package org.example.oop_lb5;
import java.sql.*;

public class dbconnector {
    private static final  String URL = "jdbc:mysql://localhost:3306/oop_lb";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD = "1234";
    private Connection connection;
    public dbconnector(){
        try {
            try {
                Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("True connection");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
