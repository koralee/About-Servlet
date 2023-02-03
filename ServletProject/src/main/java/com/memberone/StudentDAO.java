package com.memberone;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;
import javax.naming.*;

public class StudentDAO {

	private Connection getConnetcion() {
		
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		}catch (Exception e) {
			System.out.println("Connection 생성 실패!!!!");
		}
		return conn;
	}
	
	// 아이디 체크
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnetcion();
			String sql = "select * from student where id=?";
			pstmt = conn.prepareStatement(sql); //동적
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				result=false;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		
		return result;
	}// End id Check
	
	
}
