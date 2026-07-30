package com.kh.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveSessionServlet
 */
@WebServlet("/removeSession")
public class RemoveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * * 세션 종료 방법 (2가지) *
		 *   [1] session.invalidate()		 : 세션 자체를 완전히 종료 (모든 데이터 삭제)
		 *   [2] session.removeAttribute(키) : 특정 데이터만 제거 (세션은 유지)
		 *   
		 * * 로그아웃 시 서버에 저장된 세션 데이터를 삭제하여 로그인 상태를 해제함
		 *   일반적인 로그아웃 시에는 invalidate() 를 사용하여 세션을 완전히 종료함!
		 */
		
		// * 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		// * 세션에 저장된 "lunchmenu" 데이터 삭제
		session.removeAttribute("lunchmenu");
		
		// ---------------------------------
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("세션 데이터 삭제 완료<br>");
		out.println("<a href='getSession'>세션 정보 조회</a>");
	}

}







