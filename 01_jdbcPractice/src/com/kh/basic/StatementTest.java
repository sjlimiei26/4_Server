package com.kh.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * * JDBC용 객체
 *   - Connection  : DB의 연결 정보를 담고 있는 객체
 *   - Statement   : 연결된 DB에 완성된 SQL문을 전달해서 실행한 뒤, 결과를 받는 객체
 *   - ResultSet   : SELECT 문 실행 후 조회 결과를 담는 커서 기반의 객체
 */
public class StatementTest {

	public static void main(String[] args) {
		// 오라클 접속 정보를 변수에 저장해봅시다.
		// 1) db 서버 주소 2) 사용자명 3) 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##JDBC";
		String password = "JDBC";
		
		// 실행할 쿼리문
		// String searchName = "임수진";
		String searchName = "' or '1' = '1";		// SQL Injection 공격
		String sql = "SELECT * FROM MEMBER WHERE NAME = '" + searchName + "'";
		
		System.out.println(sql);
		
		// DB와 연결하기
		try( Connection conn = DriverManager.getConnection(url, user, password) ) {
			
			System.out.println(" 접속 성공 --- @@ ");
			
			Statement stmt = conn.createStatement();	// Statement 객체 생성
			ResultSet rset = stmt.executeQuery(sql);			// 쿼리문 실행 후 결과 저장
			
			/*
			if (rset.next()) {
				System.out.println(" 조회 결과 있음! ");
				
				System.out.println(rset.getInt("id") + ", "
									+ rset.getString("name") + ", "
									+ rset.getString("email"));
			} else {
				System.out.println(" 조회 결과 없음.. ");
			}
			*/
			while (rset.next()) {
				System.out.println(rset.getInt("id") + ", "
									+ rset.getString("name") + ", "
									+ rset.getString("email"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("DB 처리 중 오류 발생----!!");
			e.printStackTrace();
		}
	}

}





