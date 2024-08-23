package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.SQL_Queries;

@WebServlet("/Fetch_Servlet")
public class Fetch_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Fetch_Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter pw = response.getWriter();

        pw.print("<!DOCTYPE html>");
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<title>Student Data</title>");
        pw.print("<style>");
        pw.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }");
        pw.print("h1 { text-align: center; color: #333; }");
        pw.print("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        pw.print("table, th, td { border: 1px solid #ddd; }");
        pw.print("th, td { padding: 12px; text-align: left; }");
        pw.print("th { background-color: #4CAF50; color: white; }");
        pw.print("tr:nth-child(even) { background-color: #f2f2f2; }");
        pw.print("tr:hover { background-color: #ddd; }");
        pw.print("</style>");
        pw.print("</head>");
        pw.print("<body>");

        pw.print("<h1>All Student Data</h1>");

        List<Student> li = SQL_Queries.fetch();

        if (li != null && !li.isEmpty()) {
            pw.print("<table>");
            pw.print("<tr><th>Id</th>");
            pw.print("<th>Name</th>");
            pw.print("<th>Course</th>");
            pw.print("<th>Address</th>");
            pw.print("<th>Mobile</th>");
            pw.print("<th>Action </th>");
            pw.print("<th>Action </th></tr>");

            for (Student e : li) {
                pw.print("<tr><td>" + e.getId() + "</td>");
                pw.print("<td>" + e.getName() + "</td>");
                pw.print("<td>" + e.getCourse() + "</td>");
                pw.print("<td>" + e.getAddress() + "</td>");
                pw.print("<td>" + e.getMobile() + "</td>");
                pw.print("<td><a href='Update_Servlet?id="+e.getId()+"'>Update</a></td>");
                pw.print("<td><a href='deleteservlet?id="+e.getId()+"'>Delete</a></td></tr>");
            }

            pw.print("</table>");
        } else {
            pw.print("<p>No data found.</p>");
        }

        pw.print("</body>");
        pw.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
