package com.logon;

import java.sql.*;

public class LogonDBBean {

	private static LogonDBBean instance = null;

	private LogonDBBean() {

	}

	public static LogonDBBean getInstance() {

		if (instance == null) {
			synchronized (LogonDBBean.class) {
				instance = new LogonDBBean();
			}
		}
		return instance;
	}

	public int UserCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";

		int x = -1;
		try {
			conn = connUtil.getConnection();
			String sql = "select passwd from tempmember where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("passwd");
				if (dbpasswd.equals(passwd)) {
					x = 1;
				} else {
					x = 0;
				}
			} else {
				x = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
		return x;
	}

}
