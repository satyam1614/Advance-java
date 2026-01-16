package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");
		
		System.out.println("java is connected with mysql sucessfully....");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from st_user");
		  
		while(rs.next()) {
			System.out.println("id:" + rs.getInt(1));
			System.out.println("firstname:" + rs.getString(2));
			System.out.println("lastname:" + rs.getString(3));
			System.out.println("login:" + rs.getString(4));
			System.out.println("password:" + rs.getString(5));
			System.out.println("dob:" + rs.getDate(6));
			
		}
		conn.close();
	}

}
