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
 * Servlet implementation class GetSessionServlet
 */
@WebServlet("/getSession")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 현재 요청에 연결된 세션을 가져오기
		//		request.getSession()
		HttpSession session = request.getSession();
		
		// * 세션에서 특정 값을 조회
		//		session.getAttribute(키)
		String menu = (String)session.getAttribute("lunchmenu");
		// => getAttribute() 반환 타입이 "Object"이므로
		//			저장된 데이터 타입 (String)으로 강제 형변환
		
		// => 해당 키값에 대한 데이터가 없을 경우 null 을 반환
		// ------------------------
		
		// 브라우저에 결과 출력 ----
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (menu != null) {
			out.println("오늘 점심 메뉴 : " + menu);
		} else {
			out.println("오늘 점심은 굶었습니다...;-;");
		}
		
		// => 서버 재시작 시 세션 정보들이 모두 리셋되므로,
		//				세션 정보 저장 후 다시 조회해야 함!
	}


}
