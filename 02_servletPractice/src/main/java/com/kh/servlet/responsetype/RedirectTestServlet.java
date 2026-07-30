package com.kh.servlet.responsetype;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * redirect : 클라이언트 재요청 방식
 *   - 서버가 클라이언트(브라우저)에게 "이 주소로 다시 요청해"을 지시하는 방식
 *   - 브라우저에서는 지시를 받으면 새로운 GET 요청을 해당 URL로 다시 보냄
 *   - 따라서 브라우저의 URL 주소창이 변경됨
 *   
 * * 처리 위치 : 클라이언트(브라우저)가 새로운 요청을 보냄
 * * URL 변경 : 변경됨
 * * 요청 횟수 : 2번 (최초 요청 -> 재요청)
 * * request : 데이터 사라짐 => 새로운 요청이므로 기존 데이터는 없음!
 */
@WebServlet("/redirectTest")
public class RedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("message", "redirect로 전달한 데이터@@");
		// => redirect는 브라우저가 새 요청을 보내므로, 
		//				최초 요청을 받은 서블릿에서 데이터를 request 객체에 저장해도 사라지게 됨!
		
		// 클라이언트에게 "result.jsp"로 다시 요청하도록 응답
		//			response.sendRedirect(재요청할경로)
		
		// [1] /result.jsp ? (x) [2] result.jsp ? (o)
//		response.sendRedirect("/result.jsp");
		response.sendRedirect("result.jsp");
	}


}
