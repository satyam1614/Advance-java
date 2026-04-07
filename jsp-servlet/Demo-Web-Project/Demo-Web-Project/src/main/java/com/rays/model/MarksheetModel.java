package com.rays.model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import com.rays.bean.MarksheetBean;
import com.rays.exception.DuplicateRecordException;
import com.rays.util.JDBCDataSource;

public class MarksheetModel {
	
	public int nextPk() throws SQLException {
		
		int pk = 0;
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select max (id) from marksheet" );
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		 
		return pk + 1;
	}
   
	public int add(MarksheetBean bean)throws Exception {
	 

		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement
				("insert into marksheet values(?,?,?,?,?,?)");
		
		pstmt.setInt(1,nextPk());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getHindi());
		
		int i = pstmt.executeUpdate();
		 
		System.out.println(i + "row affected (record inserted");
		
		conn.close();
		pstmt.close();
		return bean.getId();
	}
	
	public void update (MarksheetBean bean)  throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement
				("update marksheet set rollNo =?, name =?, phy =?, maths =?, hindi =? where id =? ");
		
		
		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getMaths());
		pstmt.setInt(5, bean.getHindi());
		pstmt.setInt(6, bean.getId());
		
		int i =pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		System.out.println(i + "row affected (record update)");
		
	}
    public void delete (MarksheetBean bean) throws Exception {
    	
    	Connection conn = JDBCDataSource.getConnection();
    	
    	PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
    	
    	pstmt.setInt(1, bean.getId());
    	
    	int i = pstmt.executeUpdate();
    	
    	conn.close();
    	pstmt.close();
    	System.out.println(i + "row affected (record delete)");
    }
    
    public MarksheetBean findByRollNo(String rollNo) throws Exception {
    	
    	Connection conn = JDBCDataSource.getConnection();
    	 
    	PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where roll = ?");
    	
    	pstmt.setString(1, rollNo);
    	
    	ResultSet rs = pstmt.executeQuery();
    	
    	MarksheetBean bean = null;
    	
    	while (rs.next()) {
    		bean = new MarksheetBean();
    		bean.setId(rs.getInt(1));
    		bean.setRollNo(rs.getInt(2));
    		bean.setName(rs.getString(3));
    		bean.setPhy(rs.getInt(4));
    		bean.setMaths(rs.getInt(5));
    		bean.setHindi(rs.getInt(6));
    	}
    	return bean;
    }
    
	public MarksheetBean findByPk(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
			bean.setHindi(rs.getInt(6));
		}

		return bean;
	}
	
	public List<MarksheetBean>search(MarksheetBean bean, int pageNo, int pageSize) throws Exception{
		 
		Connection conn =JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
		
		if (bean != null) {
			if (bean.getName() !=null && bean.getName().length() > 0) {
				sql.append("and name like'" + bean.getName() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + "," + pageSize);
		}
		
		System.out.println("sql ===>" + sql.toString());
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs =pstmt.executeQuery();
		
		List<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
			bean.setHindi(rs.getInt(6));
			list.add(bean);
		}
		return list;	
	}		
	}

