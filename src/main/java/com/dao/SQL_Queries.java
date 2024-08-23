package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

public class SQL_Queries {

	public static int insert_data(Student ob)
	{
		int status=0;
		
		Connection conn=GetConnection.GetConnect();
		
		String sql="insert into student(name,course,address,mobile)value(?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getCourse());
			ps.setString(3, ob.getAddress());
			ps.setString(4, ob.getMobile());
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Student> fetch()
	{
		List<Student> li=new ArrayList<Student>();
		
		Connection conn=GetConnection.GetConnect();
		
		String sql="select * from student";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Student ob=new Student();
				
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCourse(rs.getString(3));
				ob.setAddress(rs.getString(4));
				ob.setMobile(rs.getString(5));
				
				li.add(ob);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return li;
	}
	
	public static int delete(int id)
	{
		int status=0;
		
		Connection conn=GetConnection.GetConnect();
		
		String sql="delete from student where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Student getinfo(int id)
	{
		Student ob=new Student();
		
		Connection conn=GetConnection.GetConnect();
		
		String sql="Select * from student where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCourse(rs.getString(3));
				ob.setAddress(rs.getString(4));
				ob.setMobile(rs.getString(5));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ob;
		
	}
	
	public static int update(Student ob) {
	    Connection con = GetConnection.GetConnect();
	    String sql = "UPDATE student SET name=?, course=?, address=?, mobile=? WHERE id=?";
	    int status = 0;
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setString(1, ob.getName());
	        ps.setString(2, ob.getCourse());
	        ps.setString(3, ob.getAddress());
	        ps.setString(4, ob.getMobile());
	        ps.setInt(5, ob.getId());
	        
	        status = ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return status;
	}


}
