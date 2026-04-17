package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HealthModel {
	
	public void add(HealthBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into St_Health values(?, ?, ?, ?, ?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getCode());
		pstmt.setString(3, bean.getName());
		pstmt.setString(4, bean.getUptime());
		pstmt.setString(5, bean.getStatus());

		int i = pstmt.executeUpdate();

		System.out.println(i + "row affected(records inserted...)");

		conn.close();
		pstmt.close();
	}

	public void update(HealthBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Update St_Health set code =?, name =?, uptime =?, status =? where id =?");

		pstmt.setString(1, bean.getCode());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getUptime());
		pstmt.setString(4, bean.getStatus());
		pstmt.setInt(5, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println (i + "row affected records update...");

		conn.close();
		pstmt.close();
	}

	public void delete(HealthBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Delete from St_Health where id =?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "row affected (records delete...");

	}

	public HealthBean findByPk(int Pk) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from St_Health where id = ?");

		pstmt.setInt(1, Pk);

		ResultSet rs = pstmt.executeQuery();

		HealthBean bean = null;

		while (rs.next()) {
			bean = new HealthBean();
			bean.setId(rs.getInt(1));
			bean.setCode(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setUptime
			(rs.getString(4));
			bean.setStatus(rs.getString(5));
		}
		conn.close();
		pstmt.close();
		return bean;
	}

	public List search(HealthBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		StringBuffer sql = new StringBuffer("select * from St_Health where 1=1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and Name like '" + bean.getName() + "%'");
			}
		}
		System.out.println("sql ===>" + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new HealthBean();
			bean.setId(rs.getInt(1));
			bean.setCode(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setUptime(rs.getString(4));
			bean.setStatus(rs.getString(5));
			list.add(bean);
		}
		conn.close();
		pstmt.close();
		return list;
	}


}
