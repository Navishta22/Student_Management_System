package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.SQL_Queries;

/**
 * Servlet implementation class Update_Servlet
 */
@WebServlet("/Update_Servlet")
public class Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		
		String pid=request.getParameter("id");
		int id=Integer.parseInt(pid);
		

		Student ob=SQL_Queries.getinfo(id);
		pw.print("<h1> User data</h1>");
		
		pw.print("<form action='EditServlet' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name=id value='"+ob.getId()+"'></td></tr>");
		pw.print("<tr><td>Name :</td><td><input type='text' name=name value='"+ob.getName()+"'></td></tr>");
		pw.print("<tr><td>Course :</td><td><input type='text' name=course value='"+ob.getCourse()+"'></td></tr>");
		pw.print("<tr><td>Address :</td><td><input type='text' name=address value='"+ob.getAddress()+"'></td></tr>");
		pw.print("<tr><td>Mobile :</td><td><input type='number' name=mobile value='"+ob.getMobile()+"'></td></tr>");
		pw.print("<tr><td><button type=submit>Update</button></td></tr>");
		pw.print("</table>");
		
		pw.print("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
