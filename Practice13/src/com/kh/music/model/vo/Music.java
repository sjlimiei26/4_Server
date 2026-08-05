package com.kh.music.model.vo;

import java.util.Objects;

public class Music implements Comparable<Music> {

	private String title;		// 곡명
	private String singer;		// 가수명
	
	public Music() {
		
	}
	
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		//return "Music [title=" + title + ", singer=" + singer + "]";
		return singer + " - " + title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(singer, other.singer) && Objects.equals(title, other.title);
	}

	/*
	 * 가수명 내림차순 정렬
	 *  singer
	 */
	@Override
	public int compareTo(Music o) {
		// 현재객체 : this
		// 다른객체 : 매개변수 o
		
		return o.singer.compareTo(this.singer);
	}	
	
}
