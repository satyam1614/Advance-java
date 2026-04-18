package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArchivalPolicyModel {
	
	public void add(ArchivalPolicyBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into st_archivalpolicy values (?,?,?,?,?)");
		
		pstmt.setInt(1, bean.getPolicyId());
		pstmt.setString(2, bean.getPolicyCode());
		pstmt.setString(3, bean.getDataType());
		pstmt.setString(4, bean.getArchiveAfterDays());
		pstmt.setString(5, bean.getStatus());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + "row affected records inserted...");
		
		conn.close();
		pstmt.close();
	}
	
	public void update(ArchivalPolicyBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pstmt = conn.prepareStatement("update st_archivalpolicy set policyCode = ?,dataType =?,archiveAfterDays =?,status =? where policyId =?");
		
		pstmt.setString(1, bean.getPolicyCode());
		pstmt.setString(2, bean.getDataType());
		pstmt.setString(3, bean.getArchiveAfterDays());
		pstmt.setString(4, bean.getStatus());
		pstmt.setInt(5, bean.getPolicyId());
		
int i = pstmt.executeUpdate();
		
		System.out.println(i + "row affected records update...");
		
		conn.close();
		pstmt.close();
	}
	
	public void delete (ArchivalPolicyBean bean) throws Exception {
			
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Delete from st_archivalpolicy  where policyId = ?");

		pstmt.setInt(1, bean.getPolicyId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected (records delete...");

		conn.close();
		pstmt.close();
		
	}
	
	public ArchivalPolicyBean findBypk(int pk) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_archivalpolicy where policyId = ?");

		pstmt.setInt(1, pk);

		ResultSet rs = pstmt.executeQuery();

		ArchivalPolicyBean bean = null;

		while (rs.next()) {
			bean = new ArchivalPolicyBean();
			bean.setPolicyId(rs.getInt(1));
			bean.setPolicyCode(rs.getString(2));
			bean.setDataType(rs.getString(3));
			bean.setArchiveAfterDays(rs.getString(4));
			bean.setStatus(rs.getString(5));
		}
		conn.close();
		pstmt.close();
		return bean;
	}
	
	public List search(ArchivalPolicyBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_archivalpolicy where 1=1");

		if (bean != null) {
			if (bean.getDataType() != null && bean.getDataType().length() > 0) {
				sql.append(" and DataType like '" + bean.getDataType() + "%'");
			}
		}
		System.out.println("sql ===>" + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new ArchivalPolicyBean ();
			bean.setPolicyId(rs.getInt(1));
			bean.setPolicyCode(rs.getString(2));
			bean.setDataType(rs.getString(3));
			bean.setArchiveAfterDays(rs.getString(4));
			bean.setStatus(rs.getString(5));
			
			list.add(bean);
		}

		pstmt.close();
		conn.close();
		return list;
	}
}
