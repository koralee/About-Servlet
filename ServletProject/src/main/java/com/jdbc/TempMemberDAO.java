package com.jdbc;

import java.sql.*;
import java.util.*;

public class TempMemberDAO {

	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "scott";
	private final String PASSWD = "tiger";
	
	
	
	public TempMemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 드라이버 로딩 실패!!!");
		} 
	}

	public Vector<TempMember> getMemberList(){
		Vector<TempMember> VecList = new Vector<TempMember>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
			stmt = conn.createStatement();
			String sql = "select * from tempmember";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				TempMember vo = new TempMember();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setE_mail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				
				
				VecList.add(vo);
			}
			
			
			
			
		} catch (SQLException ss) {
			ss.printStackTrace();
			} catch (Exception ee) {
			ee.printStackTrace();
			} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			if (stmt != null)
				try {
					stmt.close();
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
		
		
		
		
		return VecList;
	}
	
}
