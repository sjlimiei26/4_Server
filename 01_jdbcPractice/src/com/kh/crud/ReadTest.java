package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReadTest {
	/*
		* Read (데이터 조회) => 회원 정보 조회, 검색 등과 같이 저장된 데이터를 조회하는 기능
		* --> SQL (DQL) SELECT 사용!
	*/
	public static void main(String[] args) {
		// * MEMBER 테이블 전체 조회
		String sql = "select * from member";
		
		try (Connection conn = DriverManager.getConnection(DBInfo.URL,
														   DBInfo.USER,
														   DBInfo.PASSWORD)) {
			
			System.out.println("접속 성공 !! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
