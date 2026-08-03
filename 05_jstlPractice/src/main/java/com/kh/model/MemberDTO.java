package com.kh.model;

public class MemberDTO {
	private int id;
	private String name;
	private String email;
	private int age;
	
	public MemberDTO(int id, String name, String email, int age) {
		super();
		this.id = id;
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
