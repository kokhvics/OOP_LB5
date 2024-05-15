package org.example.oop_lb5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;

@WebServlet(name = "change", value = "/change")
public class change extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/oop_lb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private Connection connection;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String subject = request.getParameter("subject");
        String ageParam = request.getParameter("age");
        int age = ageParam != null && !ageParam.isEmpty() ? Integer.parseInt(ageParam) : 0;
        String contact = request.getParameter("contact");


        int lastPersonID = 0;
        String SELECT_LAST_ID_QUERY = "SELECT idtutors FROM tutors ORDER BY idtutors DESC LIMIT 1";
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement selectPs = connection.prepareStatement(SELECT_LAST_ID_QUERY);
            ResultSet resultSet = selectPs.executeQuery();

            if(resultSet.next()){
                lastPersonID = resultSet.getInt("idtutors");
                System.out.println(lastPersonID);
            }

            String UPDATE_QUERY = "UPDATE tutors SET name = ?, lastname = ?, subject = ?, age = ?, contact = ? WHERE idtutors = ?";
            PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, subject);
            ps.setInt(4, age);
            ps.setString(5, contact);
            ps.setInt(6, lastPersonID);
            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("Execute successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}