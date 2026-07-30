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
 *   - request 객체에 데이터를 담아두면, forward로 이동한 페이지(자원)에서도 그 데이터를 사용할 수 있음
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
     * @see HttpServlet#HttpServlet()
     */
    public ForwardTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
