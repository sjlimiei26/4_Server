package com.kh.music.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.music.model.compare.AscTitle;
import com.kh.music.model.dao.MusicDAO;
import com.kh.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<>(); // []
	private MusicDAO dao = new MusicDAO();
	
	private final String FILE_NAME = "musiclist.txt";
	
	public MusicController() {
		// 프로그램이 처음 실행되었을 때 (현재 객체가 생성되었을 때)
		// 파일에 저장된 내용을 읽어와서 리스트에 추가
		fileLoad();
		//list = dao.findAll();
		
	}

	private void fileLoad() {

		// 입력용 스트림
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)) ) {
			
			String content;
			while( (content = br.readLine()) != null) {
				
				if ( content.contains("/") ) {
					
					// "/" 를 기준으로 문자열을 쪼개기 => 문자열.split(구분자) : String[]
					String[] datas = content.split("/"); // ["가수명", "곡명"]
					
					addList( new Music(datas[1], datas[0]));
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 리스트 마지막 위치에 새로운 곡을 추가하고 1을 반환합니다. 
	 */
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	/*
	 * 리스트 **첫 번째 위치(0번 인덱스)**에 곡을 추가하고 1을 반환합니다. 
	 */
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	/*
	 * 현재 저장된 **전체 곡 목록(리스트)**을 반환합니다. 
	 */
	public List<Music> printAll() {
		return list;
	}
	/*
	 * 곡명으로 검색하여 일치하는 Music 객체를 반환합니다. 
	 * (없으면 null 반환) 
	 */
	public Music searchMusic(String title) {
		
		for(Music m : list) {
			if( m.getTitle().equals(title) ) {
				return m;
			}
		}
		
		return null;
		
	}
	/*
	 * 곡명으로 검색하여 해당 곡을 리스트에서 삭제하고, 
	 * 삭제된 기존 객체를 반환합니다. (없으면 null 반환) 
	 */
	public Music removeMusic(String title) {
		
		for(int i=0; i<list.size(); i++) {
			Music m = list.get(i);
			
			if ( m.getTitle().equals(title) ) {
				return list.remove(i);
			}
			
		}
		
		return null;
		
	}
	/*
	 * 곡명으로 검색하여 새로운 정보로 수정하고, 
	 * 수정되기 전의 기존 객체를 반환합니다. (없으면 null 반환) 
	 */
	public Music setMusic(String title, Music music) {
		
		for(int i=0; i < list.size(); i++) {
			
			//Music m = list.get(i);
			if (list.get(i).getTitle().equals(title)) {
				/*
				Music m = list.remove(i);
				list.add(i, music);
				return m;
				
				*/
				return list.set(i, music);	// 해당 인덱스에 데이터를 변경(수정)			
			}
			
		}
		
		return null;
		
	}
	/*
	 * AscTitle 클래스(Comparator)를 활용하여 
	 * 리스트를 곡명 오름차순으로 정렬하고 1을 반환합니다. 
	 */
	public int ascTitle() { // asc : 오름차순
		Collections.sort(list, new AscTitle());
		return 1;
	}
	/*
	 * Music 클래스에 구현된 기본 정렬 기준(Comparable)을 활용하여 
	 * 리스트를 가수명 내림차순으로 정렬하고 1을 반환합니다. 
	 */
	public int descSinger() {  // desc : 내림차순
		Collections.sort(list);
		return 1;
	}
	
	/*
	 * 현재까지 등록된 전체 곡 목록을 파일에 저장합니다.
	 */
	public int fileSave() {
		
		// 출력용 스트림
		try ( BufferedWriter bw = new BufferedWriter( new FileWriter(FILE_NAME) ) ) {
			
			// {가수명}/{곡명}
			for (Music m : list) {
				
				String data = m.getSinger() + "/" + m.getTitle() + "\n";
				
				bw.write(data);
				bw.flush();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}
}




