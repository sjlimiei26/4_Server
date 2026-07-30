package com.kh.servlet.parameter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /join?name=임수진&email=sjlim.iei.26@gmail.com
		// 전달된 데이터 추출
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("[GET 방식 응답페이지] 이름: " + name + 
													", 이메일: " + email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 전달한 데이터(파라미터) 추출
		// => request.getParameter("key")
		
		// * 한글 파라미터가 깨질 경우, 데이터를 추출하기 전에 인코딩을 설정
		request.setCharacterEncoding("UTF-8");
		
		// 전달되는 데이터의 키값 => name, email
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// "이름: {name}, 이메일: {email}" 브라우저에 출력
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().printf("이름: %s, 이메일: %s\n", name, email);
	}

}





