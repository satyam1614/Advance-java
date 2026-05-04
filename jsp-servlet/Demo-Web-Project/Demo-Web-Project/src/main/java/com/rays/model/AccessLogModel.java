package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.AccessLogBean;
import com.rays.util.JDBCDataSource;

public class AccessLogModel {

	public int nextPk() throws SQLException {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_accesslog");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public int add(AccessLogBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_accesslog values(?, ?, ?, ?, ?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getAccessLogCode());
		pstmt.setString(3, bean.getUserName());
		pstmt.setDate(4, new java.sql.Date(bean.getAccessTime().getTime()));
		pstmt.setString(5, bean.getStatus());

		int i = pstmt.executeUpdate();

		System.out.println(i + " row affected(record inserted)");

		conn.close();
		pstmt.close();
		return bean.getId();

	}

	public void update(AccessLogBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_accesslog set accessLogCode = ?, userName = ?, accessTime = ?, status = ? where id = ?");

		pstmt.setString(1, bean.getAccessLogCode());
		pstmt.setString(2, bean.getUserName());
		pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(4, bean.getStatus());
		pstmt.setInt(5, bean.getId());
		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		System.out.println(i + " row affected(record updated)");

	}

	public void delete(AccessLogBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_accesslog where accessLogId = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();
		System.out.println(i + " row affected(record delete)");

	}

	public AccessLogBean findByPk(int accessLogId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_accesslog where id = ?");

		pstmt.setInt(1, accessLogId);

		ResultSet rs = pstmt.executeQuery();

		AccessLogBean bean = null;

		while (rs.next()) {
			bean = new AccessLogBean();
			bean.setId(rs.getInt(1));
			bean.setAccessLogCode(rs.getString(2));
			bean.setUserName(rs.getString(3));
			bean.setAccessTime(rs.getDate(4));
			bean.setStatus(rs.getString(5));

		}

		return bean;

	}

	public List<AccessLogBean> search(AccessLogBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from st_accesslog where 1=1");

		if (bean != null) {
			if (bean.getUserName() != null && bean.getUserName().length() > 0) {
				sql.append(" and UserName like '" + bean.getUserName() + "%'");
			}

			if (bean.getAccessLogCode() != null && bean.getAccessLogCode().length() > 0) {
				sql.append(" and accessLogCode = '" + bean.getAccessLogCode() + "'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql ===> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List<AccessLogBean> list = new ArrayList<AccessLogBean>();

		while (rs.next()) {
			bean = new AccessLogBean();
			bean.setId(rs.getInt(1));
			bean.setAccessLogCode(rs.getString(2));
			bean.setUserName(rs.getString(3));
			bean.setAccessTime(rs.getDate(4));
			bean.setStatus(rs.getString(5));

			list.add(bean);
		}

		return list;

	}

}

