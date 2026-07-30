package com.kh.servlet.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * * 세션 (Session)
 *   - 데이터를 "서버" 쪽에 저장하는 방식 (* 쿠키는 "클라이언트"에 저장)
 *   - 클라이언트에게는 세션을 구분하기 위해 고유 식별자(JSESSIONID)를 쿠키 형태로 전달
 *   - 이후 클라이언트는 요청마다 JSESSIONID 쿠키를 보내고, 서버는 이 식별자를 통해 어떤 세션인지 찾아냄
 */
@WebServlet("/saveSession")
public class SaveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 현재 요청에 연결된 세션을 가져오기. (없으면 새로 생성함)
		//			request.getSession()
		//			=> 최초 호출 시 내부적으로 JSESSIONID 쿠키가 자동으로 클라이언트에게 발급
		HttpSession session = request.getSession();
		
		// * 세션에 데이터 저장하기.
		//		session.setAttribute(key, value)
		session.setAttribute("lunchmenu", "돈가스 카레");
		// => 이 데이터는 세션이 유지되는 동안 서버에 남아 있음.
		//				-> 브라우저를 닫거나, 타임아웃 전까지
		
		// ----------------------
		
		// 브라우저에 출력 ----
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("세션 저장 완료!");
	}


}
