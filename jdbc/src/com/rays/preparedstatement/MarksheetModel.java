
package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.QueryReturnType;
import com.mysql.cj.protocol.Resultset;

public class MarksheetModel {
	
	public void  add (MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into Marksheet values(?, ?, ?, ?, ?, ?,?)");
		
		pstmt.setInt(1,bean.getId());
		pstmt.setInt(2,bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4,bean.getPhy());
		pstmt.setInt(5,bean.getHindi());
		pstmt.setInt(6,bean.getMaths());
		pstmt.setInt(7,bean.getDept_id());
		
		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(records inserted...)");

		conn.close();
		pstmt.close();
	}
	
	
   public void Update (MarksheetBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Update Marksheet set rollNo = ?, name = ?, phy = ?, hindi = ?, maths = ?, dept_id = ? where id = ?");
		
		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getHindi());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getDept_id());
		pstmt.setInt(7, bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + "row affected (records update...");
		
		conn.close();
		pstmt.close();
				
   }
   
   public void delete(MarksheetBean bean) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Delete from Marksheet where id = ?");
		
		pstmt.setInt(1, bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + " row affected (records delete...");
		
		conn.close();
		pstmt.close();
	   
   }
   public MarksheetBean findByRollNo(int rollNo) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from Marksheet where rollNo = ?");
		
		pstmt.setInt(1, rollNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		MarksheetBean bean = null;
		
		while (rs.next()) {
			bean =  new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setHindi(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setDept_id(rs.getInt(7));
			
		}
			
			conn.close();
			pstmt.close();
			return bean;
			
			
		}
		
	  
	
	   
	   
   }

