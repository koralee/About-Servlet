package com.jdbc;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class ConnUtil {

	public static Connection getConnetcion() {

		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();

		} catch (Exception e) {
			System.out.println("Connection 생성 실패 !!!!");
		} finally {

		} 
		return con;
	}
}
