package com.rays.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws  Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate(
				"update st_user set firstName = 'anjali', lastName = 'yadav', login = 'anjali@gmail.com', password = 'anjali123' where id = 2");

		System.out.println(i + " row affected..(records updated)");

		conn.close();
		
	}

}
