package com.kh.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.music.controller.MusicController;
import com.kh.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("=== **** 메인 메뉴 **** ====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.println("0. 파일 저장");
			System.out.print("메뉴 번호 입력 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch (menu) {
			case 1: 
				addList();
				break;
			case 2: 
				addAtZero();
				break;
			case 3: 
				printAll();
				break;
			case 4: 
				searchMusic();
				break;
			case 5: 
				removeMusic();
				break;
			case 6: 
				setMusic();
				break;
			case 7: 
				ascTitle();
				break;
			case 8: 
				descSinger();
				break;
			case 9: 
				System.out.println("프로그램 종료");
				return;
			case 0:
				fileSave();
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
				break;
			}
			
			
		}
		
		
		
	}
	
	private void fileSave() {
		// 컨트롤러에게 파일 저장을 요청하고
		//		결과에 따라 "완료", "실패" 출력
		if (mc.fileSave() == 1) {
			System.out.println("파일 저장이 완료되었습니다.");
		} else {
			System.out.println("파일 저장에 실패했습니다.");
		}
		
	}

	public void addList() {
		
		System.out.println("****** 마지막 위치에 곡 추가 *******");
		
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addList( new Music(title, singer) );
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		
		System.out.println("****** 첫 위치에 곡 추가 ******");
		
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addAtZero( new Music(title, singer) );
		if (result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
		
	}
	
	public void printAll() {
		
		System.out.println("****** 전체 곡 목록 출력 ******");
		List<Music> allList = mc.printAll();
		
		System.out.println(allList); // TODO:
		
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡명 : ");
		String title = sc.nextLine();
		
		Music music = mc.searchMusic(title);
		
		if (music == null) {
			System.out.println("해당 곡을 찾을 수 없습니다.");
		} else {
			System.out.println(music + "을(를) 검색했습니다.");
		}
		
	}
	
	public void removeMusic() {
		
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡명 : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title);
		
		if (music == null) {
			System.out.println("해당 곡이 존재하지 않습니다.");
		} else {
			System.out.println(music + "을(를) 삭제했습니다.");
		}
		
	}
	
	public void setMusic() {
		
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡명 : ");
		String searchTitle = sc.nextLine();
		
		System.out.print("수정할 곡명 : ");
		String newTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String newSinger = sc.nextLine();
		
		Music music = mc.setMusic(searchTitle, 
									new Music(newTitle, newSinger));
		
		if (music == null) {
			System.out.println("해당 곡은 존재하지 않습니다.");
		} else {
			System.out.println(music + "의 값이 변경되었습니다.");
		}	
		
	}
	
	public void ascTitle() {
		System.out.println("****** 곡명 오름차순 정렬 ******");
		
		int result = mc.ascTitle();
		if (result == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
	public void descSinger() {
		System.out.println("****** 가수명 내림차순 정렬 ******");
		
		int result = mc.descSinger();
		if (result == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
		
	}

}








