package com.kh.music.model.dto;

import com.kh.music.model.vo.Music;

public class MusicDTO extends Music {

	private int id;
	
	public MusicDTO(int id, String title, String singer) {
		super(title, singer);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[" + id + "]" + super.toString();
	}
}
