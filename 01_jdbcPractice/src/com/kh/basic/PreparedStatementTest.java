package com.kh.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * PreparedStatement
 * - Statement 와 동일하게 sql을 실행하는 객체이지만, 사용 방식과 동작 흐름이 다름
 * - 변수의 값을 sql문에 포함시키면, 구문이 아닌 순수한 문자열 데이터로만 처리됨
 *   => 전체 조회가 되지 않음!
 */
public class PreparedStatementTest {

	public static void main(String[] args) {
		// * DB 접속 정보 : url, 사용자명, 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##JDBC";
		String password = "JDBC";
		
		// 실행할 쿼리문
		// String searchName = "임수진";
		String searchName = "' or '1' = '1";		// SQL Injection 공격
		// String sql = "SELECT * FROM MEMBER WHERE NAME = '" + searchName + "'";
		String sql = "SELECT * FROM MEMBER WHERE NAME = ?";
		
		System.out.println(sql);
		// Connection 객체 생성 -> PreparedStatement 객체 생성 -> SQL 실행 후 결과
		try ( Connection conn = DriverManager.getConnection(url, user, password) ) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);  // SQL문은 미완성 상태여야 함!
			
			// 쿼리문 실행 전, 완성 시키기 => ?에 사용될 값을 지정
			pstmt.setString(1, searchName);	// 쿼리문에서 첫 번째 물음표 위치를 searchName 값으로 사용
			
			// 실행
			ResultSet rset = pstmt.executeQuery();
			
			if (rset.next()) {
				System.out.println("조회 결과 있음!");
				
				System.out.println(rset.getInt("id") + ", "
						+ rset.getString("name") + ", "
						+ rset.getString("email"));
			} else {
				System.out.println("조회 결과 없음!");
			}
			
		} catch (SQLException e) {
			System.out.println("DB 처리 중 오류 발생 ---- @@");
			e.printStackTrace();
		}
	}

}




