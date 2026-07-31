package com.kh.mvc.model;

/*
 * * Model - DTO : 전달되는 데이터를 담는 역할.
 * 		=> member 테이블의 한 행을 객체로 표현하기 위해 사용 
 */
public class MemberDTO {
	// 필드 --> member 테이블의 컬럼 정보로 변수 선언
	private int id;
	private String name;
	private String email;
	private int age;
	
	// * 전체 목록 조회 후 결과를 담을 객체 생성 시 사용
	public MemberDTO(int id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	// * 회원 등록 시 데이터를 담을 객체로 사용
	public MemberDTO(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}
	
	
}




