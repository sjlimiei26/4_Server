package com.kh.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * * DB 접속 정보 및 Connection 객체 생성 작업을 관리하는 클래스 (도구)
 * 
 * 	 => DBUtil.getConnection() 호출하여 Connection 객체를 반환
 */
public class DBUtil {
	// ---- DB(Oracle) 접속 정보 ----
	// * URL => jdbc:oracle:thin:@호스트:포트:sid
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// * DB 사용자 계정
	private static final String USER = "C##JDBC";
	// * DB 사용자 비밀번호
	private static final String PASSWORD = "JDBC";

	// ---- Connection 객체 생성 후 반환 메소드 ----
	public static Connection getConnection() throws SQLException {
		
		try {
			
			// * 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
}







