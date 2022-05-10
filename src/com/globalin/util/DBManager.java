package com.globalin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	// url, username, password
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "minseok";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// select 문 전용 close
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// update, insert, delete 문 dml 전용 close
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
