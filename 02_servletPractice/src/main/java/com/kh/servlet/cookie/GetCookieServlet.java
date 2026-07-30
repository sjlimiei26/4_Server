package com.kh.servlet.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 저장된 쿠키 읽기 : request.getCookies()
		//				=> 브라우저가 보낸 모든 쿠키를 Cookie 배열로 반환
		//				   저장된 쿠키가 없다면, null을 반환 (null 체크 필수!)
		Cookie[] cookies = request.getCookies();
		
		String nickname = "Unknown";	// 쿠키를 찾지 못했을 경우 사용할 기본값
		
		// null 체크
		if (cookies != null) {
			
			// 반복문으로 쿠키배열을 순회
			for(Cookie c : cookies) {
				// 쿠키 이름(key) 조회 : getName()
				//		쿠키 이름이 "nickname"인 것을 찾기
				if ( c.getName().equals("nickname") ) {
					// 쿠키 이름에 대한 값 조회 : getValue()
					nickname = c.getValue();
					break;		// "nickname" 쿠키를 찾았으므로 반복문 종료
				}
			}
			
		}
		
		// 브라우저로 결과 출력 ----
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h3> nickname: " + nickname + "</h3>");
	}


}
