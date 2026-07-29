package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	/*
	 * * Update (데이터 수정) => 비밀번호 변경, 도서 정보 수정 등과 같이 기존에 저장된 데이터의 일부 값을 변경하는 기능
	 *   --> DML 중 UPDATE 사용!
	 */
	public static void main(String[] args) {
		// ID 값을 입력 받고, 변경할 이메일을 입력 받아 변경
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID 입력 : ");
		int id = sc.nextInt();
		
		System.out.print("새로운 이메일 입력 : ");
		String email = sc.next();
		
		// -------------------------------------
		
		String sql = "UPDATE MEMBER SET EMAIL = ? WHERE ID = ?";
		// - 첫번째 물음표 : 새로운 이메일
		// - 두번째 물음표 : ID
		
		try (Connection conn = 
				DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, id);
			
			int result = pstmt.executeUpdate();			
			System.out.println(result + "행의 이메일이 " + email + "로 변경됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();

	}

}
