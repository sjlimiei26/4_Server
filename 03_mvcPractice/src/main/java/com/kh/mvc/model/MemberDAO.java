package com.kh.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mvc.util.DBUtil;

/*
 * * Model - DAO : DB와 연결하여 SQL문을 실행하는 역할
 * 
 *   Controller 에서 이 클래스의 메소드만 호출하고,
 *   내부에서 어떤 SQL문이 실행되는지는 알 필요가 없음! (관심사 분리)
 */
public class MemberDAO {

	/*
	 * 등록된 회원 목록 조회
	 */
	public List<MemberDTO> findAll() {
		// 조회된 결과를 담을 리스트
		List<MemberDTO> list = new ArrayList<>();
		
		// 실행할 쿼리문(sql)
		//    -> 전체 회원 목록 조회 (id 내림차순 정렬)
		String sql = "SELECT * FROM MEMBER ORDER BY ID DESC";
		
		// Connection 객체 생성... Statement 객체 생성... SQL 실행...
		try (Connection conn = DBUtil.getConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// DQL(SELECT)	=> executeQuery(); : ResultSet
			// DML(INSERT/UPDATE/DELETE)	=> executeUpdate(); : int
			
			ResultSet rset = pstmt.executeQuery();
			
			// 조회 결과 행의 개수 
			//		1개?     --> PK, UNIQUE 컬럼을 조건으로 제시했을 경우 
			// 		여러 개?  --> PK, UQ 컬럼이 아닌 조건을 제시했을 경우, 전체 조회..
			
			// * 조회 결과 유무 => rset.next() : boolean
			while(rset.next()) {
				
				// 조회 결과가 있으면, 각 컬럼의 값을 추출하여 MemberDTO 객체로 저장
				MemberDTO m = new MemberDTO(
							rset.getInt("id"),
							rset.getString("name"),
							rset.getString("email"),
							rset.getInt("age")
						);
				
				// list (조회결과리스트)에 추가				
				list.add(m);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return list;
	}
	
	/*
	 *  회원 등록 메소드 (데이터 추가)
	 */
	public void insert(MemberDTO m) {
		
		// 실행할 쿼리문 => 데이터 추가 (DML, INSERT)
		String sql = "INSERT INTO MEMBER VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?)";
		
		// 드라이버 로드
		// Connection 객체 생성
		// ---- DBUtil.getConnection() 처리 해둠! ---
		// PreparedStatement 객체 생성
		// SQL문 실행 
		
		try ( Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			
			// sql문의 ? 채우기!
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getAge());
			
			// 실행! DML => pstmt.executeUpdate()
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 추가됨.");
			} else {
				System.out.println("추가된 행이 없음.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





