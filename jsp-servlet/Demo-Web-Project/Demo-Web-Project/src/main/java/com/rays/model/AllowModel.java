package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.AllowBean;
import com.rays.util.JDBCDataSource;

public class AllowModel {

	public int nextPk() throws SQLException {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_allow");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public int add(AllowBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_allow values(?, ?, ?, ?, ?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getAllowCode());
		pstmt.setString(3, bean.getUserName());
		pstmt.setString(4, bean.getSource());
		pstmt.setString(5, bean.getStatus());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record inserted)");

		conn.close();
		pstmt.close();
		return bean.getId();

	}

	public void update(AllowBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_allow set allowCode = ?, userName = ?, source = ?, status = ? where id = ?");

		pstmt.setString(1, bean.getAllowCode());
		pstmt.setString(2, bean.getUserName());
		pstmt.setString(3,bean.getSource());
		pstmt.setString(4, bean.getStatus());
		pstmt.setInt(5, bean.getId());
		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		System.out.println(i + " row affected(record updated)");

	}

	public void delete(AllowBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_allow where Id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		System.out.println(i + " row affected(record delete)");

	}

	public AllowBean findByPk(int accessLogId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_allow where id = ?");

		pstmt.setInt(1, accessLogId);

		ResultSet rs = pstmt.executeQuery();

		AllowBean bean = null;

		while (rs.next()) {
			bean = new AllowBean();
			bean.setId(rs.getInt(1));
			bean.setAllowCode(rs.getString(2));
			bean.setUserName(rs.getString(3));
			bean.setSource(rs.getString(4));
			bean.setStatus(rs.getString(5));

		}

		return bean;

	}

	public List<AllowBean> search(AllowBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from st_allow where 1=1");

		if (bean != null) {
			if (bean.getUserName() != null && bean.getUserName().length() > 0) {
				sql.append(" and UserName like '" + bean.getUserName() + "%'");
			}

			if (bean.getAllowCode() != null && bean.getAllowCode().length() > 0) {
				sql.append(" and allowCode = '" + bean.getAllowCode() + "'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql ===> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List<AllowBean> list = new ArrayList<AllowBean>();

		while (rs.next()) {
			bean = new AllowBean();
			bean.setId(rs.getInt(1));
			bean.setAllowCode(rs.getString(2));
			bean.setUserName(rs.getString(3));
			bean.setSource(rs.getString(4));
			bean.setStatus(rs.getString(5));

			list.add(bean);
		}

		return list;

	}

}

