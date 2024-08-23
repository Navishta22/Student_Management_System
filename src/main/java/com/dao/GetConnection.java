package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	
		public static Connection GetConnect()
		{
			Connection conn=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url= "jdbc:mysql://localhost:3306/student_management_servlet";
				String user="root";
				String password="codeforproject";
				
				conn=DriverManager.getConnection(url,user,password);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return conn;
		}
	}

