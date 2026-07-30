package com.kh.servlet.lifecycle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * 서블릿의 싱글톤 특성 *
 *   : 서블릿은 톰캣이 최초 요청 시 딱 1번만 객체를 생성하고,
 *     이후 모든 요청에 대해 "같은 객체"를 재사용함. (싱글톤 패턴)
 *     
 *   => 주의할 부분. 서블릿에 필드(인스턴스 변수)를 선언하면
 *   			   모든 사용자가 한 변수를 공유하게 됨.
 *      동시성 문제 : 사용자 A와 사용자 B가 동시에 요청하면 필드 값을 서로 공유하여
 *      			예상치 못한 결과가 발생됨.
 */
@WebServlet("/count")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int count = 0;

	/**
	 * * 요청 시 count 값을 1 증가 후 현재 count 값을 출력
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().println("현재 count : " + count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
