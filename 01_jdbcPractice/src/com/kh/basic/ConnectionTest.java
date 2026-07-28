package com.kh.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		// * 오라클 사용자 계정 추가: C##JDBC / JDBC (최초 1번)
		
		// * 오라클 접속 정보 *
		// 1) url : 로컬 PC
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 2) 사용자 계정(이름)
		String userName = "C##JDBC";
		// 3) 비밀번호
		String password = "JDBC";
		/*
		try {
			// [1] 드라이버 로드 (수동 방식, 과거 버전)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("드라이버 로드 완료!");
		*/
		try (Connection conn = DriverManager.getConnection(url, userName, password);)  {
			
			System.out.println("오라클 DB 연결 성공: " + conn);
			
		} catch (SQLException e) {
			System.out.println("DB 연결 실패! Build Path 또는 접속 정보를 확인하세요.");
			e.printStackTrace();
		}
		
	}

}
