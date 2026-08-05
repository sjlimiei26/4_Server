package com.kh.music.model.compare;

import java.util.Comparator;

import com.kh.music.model.vo.Music;

public class AscTitle implements Comparator<Music> {

	/*
	 * 곡명 기준 오름차순 
	 * => 곡명이 같으면 가수명 오름차순
	 */
	@Override
	public int compare(Music o1, Music o2) {
		int result = o1.getTitle().compareTo(o2.getTitle());
		
		if (result == 0) {
			return o1.getSinger().compareTo(o2.getSinger());
		}
		
		return result;
	}

}
