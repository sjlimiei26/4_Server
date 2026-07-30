package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * * 기본 서블릿 구조 *
 * 
 *   @단어   : 어노테이션 - 컴파일러 (또는 서버) 에게 전달하는 특별한 주석으로,
 *   					 어노테이션마다 컴파일러나 서버가 특정 동작을 자동으로 수행해줌
 *   
 *   @WebServlet(요청받을_주소)
 *   : 이 서블릿이 어떤 주소로 요청을 받아 처리할 것인지 매핑(연결)
 *   : 브라우저에서 http://localhost:8888/sp/hello 로 접속하면 이 서블릿이 실행된다.
 *   : web.xml 파일 없이 어노테이션 하나로 URL 매핑을 설정할 수 있는 장점이 있다.
 *   
 *   
 *   HttpServlet 상속
 *   : HttpServlet 상속을 받아야 서블릿 컨테이너(Tomcat)이 이 클래스를 서블릿으로 인식
 *   : 이미 정의되어 있는 doGet, doPost 메소드를
 *     원하는 동작에 맞춰서 오버라이딩(재정의)해서 처리할 수 있다.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    	// super();
    }

	/**
	 * * doGet : GET 방식으로 요청이 왔을 때 실행되는 메소드
	 * 
	 * 	 - 브라우저 주소창에 URL을 직접 입력하거나,
	 * 		<a href="..."> 링크를 클릭하면 GET 요청이 발생됨
	 * 
	 * @param request  클라이언트가 보낸 요청 정보를 담고 있는 객체
	 * 				   (사용자가 입력한 값, 요청 방식, 요청 IP, URL 등)
	 * 
	 * @param response 클라이언트에게 응답할 때 사용되는 객체
	 * 				   (응답 타입, 응답 내용 등을 설정)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// => 브라우저에 "Served at: /sp" 출력될 것임!
		
		// * 응답 데이터(컨텐츠) 타입과 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// * response.getWriter() : 응답 본문(body)에 텍스트를 직접 쓸 수 있는 PrintWriter 객체 반환
		PrintWriter out = response.getWriter();
		
		out.println("<h1> Hello, Servlet! </h1>");
		out.println("hello 요청에 대한 응답 화면입니다.");
	}

	/**
	 *  * doPost : POST 방식으로 요청이 왔을 때 실행되는 메소드
	 *  
	 *  현재 코드 기준으로 doGet()을 호출하여 GET/POST 모두 같이 처리되도록 작성되어 있음!
	 *  get, post 처리 로직이 동일한 경우 이 방식을 적용하여 위임할 수 있음.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
