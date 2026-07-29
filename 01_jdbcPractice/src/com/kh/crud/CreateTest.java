package com.kh.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateTest {
	/*
	 * Create (데이터 추가) => 회원 등록, 도서 등록, 상품 등록 등과 같이 데이터가 추가되는 기능
	 * ---> SQL(DML) 중 INSERT 사용!
	 */
	public static void main(String[] args) {
		// TODO: 이름, 이메일, 나이를 입력 받기 (name, email, age)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// -----------------------------------
		
		// 실행할 쿼리문
		String sql = "INSERT INTO MEMBER VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?)";
		
		// 1) Connection 객체 생성 -- DB 접속 정보
		try (Connection conn = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD)) {

			// 2) PreparedStatement 객체 생성 -- Connection 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// * 실행할 쿼리문이 DML일 경우,
			//			JDBC의 기본 상태는 auto commit(자동 커밋) 이므로,
			//			직접 트랜잭션 처리를 제어하고자 할 경우 Connection 객체 생성 후 setAutoCommit(false) 를 실행해야 함!
			conn.setAutoCommit(false);
			
			// 미완성 쿼리문을 완성 상태로 변경 --> ?를 특정 값으로 변경
			pstmt.setString(1, name);		// 첫 번째 물음표 위치에 name 변수의 값으로 변경
			pstmt.setString(2, email);		// 두 번째 위치에 email 변수 값으로 변경
			pstmt.setInt(3, age);			// 세 번째 위치에 age 변수 값으로 변경
			
			// 3) 쿼리문 실행 후 결과 반환(받기) -- PreparedStatement 객체
			//    DML 실행 : executeUpdate() 호출
			int result = pstmt.executeUpdate();
			
			System.out.println("추가된 행: " + result);    // 추가 성공: 1, 실패: 0 
			
			// * 결과 값에 따라 트랜잭션 처리 : result 값이 1이면 적용(commit), 1이 아니면 취소(rollback)
			if (result == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			// 4) 자원 반납 (close) --> try with resources 구문 사용 시 생략 가능!			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}







