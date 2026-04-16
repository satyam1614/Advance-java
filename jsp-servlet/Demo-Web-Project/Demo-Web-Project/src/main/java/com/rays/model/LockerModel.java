package com.rays.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.LockerBean;
import com.rays.util.JDBCDataSource;

public class LockerModel {
	
	public int  nextPk() throws SQLException {
		
		int pk = 0;
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select max (id) from st_locker");
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			 pk = rs.getInt(1);
		}
		
		rs.close();
		return pk + 1;
	}
	 public long add(LockerBean bean) throws Exception{
		 
		 Connection conn = JDBCDataSource.getConnection();
		 
		 PreparedStatement pstmt = conn.prepareStatement("insert into st_locker values(?,?,?,?)");
		 pstmt.setLong(1,  nextPk());
		 pstmt.setString(2, bean.getLockerNumber());
		 pstmt.setString(3,  bean.getLockerType());
		 pstmt.setBigDecimal(4, bean.getAnnualFee());
		 int i = pstmt.executeUpdate();

			System.out.println(i + " row affected(record inserted)");

			conn.close();
			pstmt.close();
			return bean.getLockerId();
		 
	 }
	 
	 public void  update  (LockerBean bean) throws Exception {
		 
		 Connection conn = JDBCDataSource.getConnection();
		 
		 PreparedStatement pstmt = conn.prepareStatement(
				 "update st_locker set number = ?, type = ?, annulFee =? where id = ?");
		 
		 pstmt.setString(1, bean.getLockerNumber());
		 pstmt.setString(2, bean.getLockerType());
		 pstmt.setBigDecimal(3, bean.getAnnualFee());
		 pstmt.setLong(4, nextPk());
		 
		 int i = pstmt.executeUpdate();
		 
		 conn.close();
		 pstmt.close();
		 System.out.println(i + "row affected(record updated");
		 
	 }
	 
	 public void delete (LockerBean bean) throws Exception{
		 
		 Connection conn =JDBCDataSource.getConnection();
		  
		 PreparedStatement pstmt = conn.prepareStatement("delete from st_locker where id = ?");
		 
		 pstmt.setLong(1, bean.getLockerId());
		 
		 int i =pstmt.executeUpdate();
		 
		 conn.close();
		 pstmt.close();
		 System.out.println(i + "row affected (record delete)");
		 
	 }
	 
	 public LockerBean findByPk (long id) throws Exception{
		 
		 Connection conn = JDBCDataSource.getConnection();
		 
		 PreparedStatement pstmt = conn.prepareStatement("select * from st_locker where id = ?");
		 
		 pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();

			LockerBean bean = null;
			
			while(rs.next()) {
				bean = new LockerBean();
				bean.setLockerId(rs.getLong(1));
				bean.setLockerNumber(rs.getString(2));
				bean.setLockerType(rs.getString(3));
				bean.setAnnualFee(rs.getBigDecimal(4));
			}
			
			return bean;

	 }
	 
	 public List<LockerBean> search(LockerBean bean, int pageNo, int pageSize) throws Exception {
		 
		 Connection conn = JDBCDataSource.getConnection();
		 
		 StringBuffer sql = new StringBuffer("select * from st_locker where 1=1");
		 
		 if (bean != null) {
			 if (bean.getLockerNumber() != null && bean.getLockerNumber().length() > 0) {
					sql.append(" and LockerNumber like '" + bean.getLockerNumber() + "%'");
				}
				if (bean.getLockerType() != null && bean.getLockerType().length() > 0) {
					sql.append(" and LockerType like '" + bean.getLockerType() + "%'");
				}
		      
		 }		 
		  
		 if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append(" limit " + pageNo + ", " + pageSize);
			}

			System.out.println("sql ===> " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			List<LockerBean> list = new ArrayList<LockerBean>();
			
			while (rs.next()) {
				bean = new LockerBean();
				bean.setLockerId(rs.getLong(1));
				bean.setLockerNumber(rs.getString(2));
				bean.setLockerType(rs.getString(3));
				bean.setAnnualFee(rs.getBigDecimal(4));
				list.add(bean);
			}
			
			return list;
			
	 }
}

