package com.kh.model;

public class MemberDTO {
	
	private String name;
	private int age;
	
	public MemberDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	
}
