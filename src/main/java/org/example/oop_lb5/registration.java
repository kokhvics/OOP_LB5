package org.example.oop_lb5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet(name = "registration", value = "/registration")
public class registration extends HttpServlet {
    private static final  String URL = "jdbc:mysql://localhost:3306/oop_lb";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD = "1234";
    private Connection connection;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String subject = request.getParameter("subject");
        int age = Integer.parseInt(request.getParameter("age"));
        String contact = request.getParameter("contact");

        PreparedStatement ps = null;
        String INSERT_NEW = "INSERT INTO tutors (`name`, `lastname`, `subject`, `age`, `contact`) VALUES (?, ?, ?, ?, ?)";
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ps = connection.prepareStatement(INSERT_NEW); // Initialize the PreparedStatement here
            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, subject);
            ps.setInt(4, age);
            ps.setString(5, contact);
            System.out.println(ps);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        dbconnector conn = new dbconnector();
        String query = "SELECT * from tutors";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Таблица</title><link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"></head><body><div class=\"container mt-5\"><h2>Данные о репетиторах школы</h2><table class=\"table table-bordered\"><thead><tr><th style=\"width: 20px\">#</th><th>Имя</th><th>Фамилия</th><th>Предмет</th><th>Возраст</th><th>Контактная информация</th></tr></thead><tbody>");
        int counter = 1;
        try {
            Statement statement = conn.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                out.println("<tr><td>" + counter + "</td><td>" + resultSet.getString("name") + "</td><td>" + resultSet.getString("lastname") + "</td><td>" + resultSet.getString("subject") + "</td><td>" + resultSet.getInt("age")+ "</td><td>" + resultSet.getString("contact") + "</td></tr>");
                counter++;
                Tutor tutor = new Tutor(resultSet.getString("name"), resultSet.getString("lastname"), resultSet.getString("subject"), resultSet.getInt("age"), resultSet.getString("contact"));
                System.out.println(tutor.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("</tbody></table></div><script src=\"js/bootstrap.bundle.min.js\"></script></body></html>");
    }

}