package com.kh.servlet.responsetype;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * forward : 서버 내부 전달
 *   - 서블릿이 요청을 받아 처리한 뒤, 화면 응답을 다른 자원(jsp 등)에게 넘기는 방식
 *   - 이 전달은 서버 내부에서만 동작되며, 브라우저는 이 과정을 알 수 없음.
 *   - 따라서 브라우저의 URL 주소창은 변경되지 않음.
 *   
 * * request.setAttribute(key, value)
 *   - request 객체에 데이터를 담아두면, forward 로 이동한 페이지(자원)에서도 그 데이터를 사용할 수 있음
 *   - 단, 같은 요청 안에서만 데이터가 유지됨. (요청이 새로 들어오면 데이터는 사라짐)
 *   
 * * 처리 위치 : 서버 내부
 * * URL 변경 : 변경되지 않음 (최초 요청 그대로 유지)
 * * 요청 횟수 : 1번
 * * request : 유지됨 -> 데이터 공유 가능
 */
@WebServlet("/forwardTest")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * * request 객체에 임의의 데이터를 저장 후
	 * 		result.jsp 페이지로 포워딩(forward)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * request 객체에 데이터 저장
		//			request.setAttribute(키값, 저장할데이터)
		request.setAttribute("message", "서블릿에서 저장한 데이터 @@");
		
		// * result.jsp 페이지로 포워딩
		//			request.getRequestDispatcher(경로) => 지정한 자원(경로)으로 요청을 넘길 준비
		//			.forward(request, response)      => 실제로 request, response 객체를 그대로 해당 자원에게 전달
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}


}



