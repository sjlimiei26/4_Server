package com.kh.servlet.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * * 쿠키 (Cookie)
 *   - 서버가 만들어서 클라이언트(브라우저)에게 전달하는 작은 데이터 조각
 *   - 브라우저는 쿠키를 받으면 로컬에 저장해두고, 이후 동일한 서버로 요청을 보낼 때마다 자동으로 함께 전송
 *   ==> 데이터가 클라이언트쪽에 저장됨!
 *   
 * * 쿠키 활용 예) 자동 로그인, 최근 본 상품, 팝업 "오늘 하루 보지 않기" 등
 *   -> 클라이언트에 저장되므로 사용자가 임의로 수정하거나 탈취될 수 있음.
 *      민감한 정보(비밀번호, 개인정보 등)는 쿠키에 직접 저장하지 않는다!
 */
@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 쿠키 생성 => Cookie("키", "값")
		Cookie cookie = new Cookie("nickname", "sujin07");
		
		// - 유효 시간 설정 (단위: 초)
		//		setMaxAge(시간)
		//		=> 1시간 설정한다면... 3600 / 60 * 60
		cookie.setMaxAge(60*60);
		// => 설정하지 않는 경우 브라우저를 닫는 순간 쿠키는 삭제됨. (세션 쿠키)
		
		// - 쿠키가 전송될 경로 설정
		//		setPath(경로)
		//		=> "/" 로 설정하면 이 서버의 모든 경로에서 요청 시 쿠키를 함께 전송
		//		=> "/shop" 으로 설정하면 /shop 경로 이하에서만 전송
		cookie.setPath("/");
		
		// 생성한 쿠키를 응답 헤더에 담아 클라이언트로 전송(전달)
		//		response.addCookie(생성한쿠키)
		response.addCookie(cookie);
		// => 브라우저는 이 쿠키를 받아 로컬에 저장해 두고, 이후 요청마다 자동으로 보내줌
		
		// 브라우저에 표시---
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("쿠키 저장 완료!!");
	}

}


