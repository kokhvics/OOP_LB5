package org.example.oop_lb5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;

@WebServlet(name = "delete", value = "/delete")
public class delete extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/oop_lb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private Connection connection;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PreparedStatement ps = null;
        String DELETE_QUERY = "DELETE FROM tutors WHERE idtutors = ?";
        int lastPersonId = 0;
        String SELECT_LAST_ID_QUERY = "SELECT idtutors FROM tutors ORDER BY idtutors DESC LIMIT 1";

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement selectPs = connection.prepareStatement(SELECT_LAST_ID_QUERY);
            System.out.println(SELECT_LAST_ID_QUERY);
            ResultSet resultSet = selectPs.executeQuery();

            if (resultSet.next()) {
                lastPersonId = resultSet.getInt("idtutors");
                System.out.println(lastPersonId);
            }
            ps = connection.prepareStatement(DELETE_QUERY);
            ps.setInt(1, lastPersonId);
            ps.executeUpdate();
            System.out.println("Delete operation successful");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        response.sendRedirect("index.jsp");
    }
}