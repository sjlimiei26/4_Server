package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest {
	/*
	 * * Delete (데이터 삭제) => 회원 삭제, 도서 삭제 등과 같이 기존에 저장된 데이터 자체를 제거하는 기능
	 * --> DML 중 DELETE 사용!
	 */

	public static void main(String[] args) {
		// 삭제할 ID 값을 입력 받아,
		//		해당 데이터를 DB에서 삭제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 ID 입력 : ");
		int id = sc.nextInt();
		// ----------------------------------
		
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		
		// 1) Connection 객체 생성 -- DB 접속 정보 (url, 사용자명, 비밀번호)
		try (Connection conn = 
				DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);) {
			// 트랜잭션 처리를 직접 하고자 할 경우... setAutoCommit(false) 실행
		
			// 2) PreparedStatement 객체 생성 -- Connection
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//		+ 쿼리문이 완성되어 있는 지 체크 => ?를 채웠는지!
			pstmt.setInt(1, id);
			// 3) 쿼리문 실행 후 결과 받기 -- PreparedStatement
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삭제됨.");
			// 4) 자원 반납 (close) --> try~with~resources 구문으로 처리 가능!
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
