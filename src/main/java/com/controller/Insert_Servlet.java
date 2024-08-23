package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.SQL_Queries;

/**
 * Servlet implementation class Insert_Servlet
 */
@WebServlet("/Insert_Servlet")
public class Insert_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		
		Student ob=new Student();
		
		ob.setName(name);
		ob.setCourse(course);
		ob.setAddress(address);
		ob.setMobile(mobile);
		
		int status=SQL_Queries.insert_data(ob);
		
		if(status==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			pw.print("<h1>Data Inserted Successfully</h1>");
			
		}
		else {
			pw.print("<h1>Error in Data Insertion</h1>");
		}
		
	}

}
