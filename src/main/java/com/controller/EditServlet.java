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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		String pid=request.getParameter("id");
		int id=Integer.parseInt(pid);
		String name=request.getParameter("name");
		String course=request.getParameter("course");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		
		Student ob=new Student();
		ob.setId(id);
		ob.setName(name);
		ob.setCourse(course);
		ob.setAddress(address);
		ob.setMobile(mobile);
		
		int status=SQL_Queries.update(ob);
		
		if(status==1)
		{
			pw.print("<h1>Data Updated Successfully</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Fetch_Servlet");
			rd.include(request, response);
		}
		else
		{
			pw.print("Error In Updation");
		}
		
	}

	}


