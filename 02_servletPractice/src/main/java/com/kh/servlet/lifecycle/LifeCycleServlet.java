package com.kh.servlet.lifecycle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * * 서블릿 생명주기 *
 * 
 * 	 서블릿 컨테이너(Tomcat)은 서블릿 객체를 3단계로 관리함.
 * 
 *   [1] init()		: 최초 요청 시 딱 1번만 호출됨. (객체 생성 시점)
 *   				  초기화 작업(DB 연결, 설정 로드 등)을 이 메소드에 작성.
 *   				  이후 요청부터는 이미 만들어진 객체를 재사용함. (싱글톤)
 *   
 *   [2] service()  : 요청이 들어올 때마다 매번 호출됨.
 *   				  HTTP 요청 방식(GET/POST 등)을 판단하여 doGet(), doPost() 등으로 자동 분기함.
 *   				  우리가 직접 오버라이딩하지 않아도 HttpServlet이 처리해줌.
 *   
 *   [3] destroy()  : 서버가 종료되거나 서블릿이 컨테이너에서 제거될 때 딱 1번만 호출됨.
 *   				  자원 해제(DB 연결 종료 등) 작업을 작성.
 */
@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 서블릿 초기화 메소드. 최초 요청 시 딱 1번만 호출됨.
     */    
	@Override
	public void init() throws ServletException {
		System.out.println("/lifecycle 의 init() 호출 ----- @@");
	}   

	/**
	 * 서블릿 소멸 메소드. 서버 종료 또는 서블릿 언로드(해제) 시 딱 1번만 호출됨.
	 */
	@Override
	public void destroy() {
		System.out.println("/lifecycle 의 destroy() 호출 ----- @@");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버 콘솔창에 출력
		System.out.println("/lifecycle 의 doGet() 호출 ------ @@");
		
		// 클라이언트(브라우저)에 출력
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h2> 생명주기 테스트 페이지 - 서버 콘솔을 확인하세요! </h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
