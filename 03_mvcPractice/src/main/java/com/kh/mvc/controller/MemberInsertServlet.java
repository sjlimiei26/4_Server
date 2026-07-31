package com.kh.mvc.controller;

import java.io.IOException;

import com.kh.mvc.model.MemberDAO;
import com.kh.mvc.model.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/member/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDAO dao = new MemberDAO();
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달 받은 데이터를 추출
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt( request.getParameter("age") );
		// String ("20") ----> int (20) 
		
		// DAO 에게 데이터 추가 요청
		//   --> MemberDTO 객체를 생성하여 전달
		MemberDTO m = new MemberDTO(name, email, age);
		
		dao.insert(m);
		
		// 회원 목록 페이지로 재요청 => redirect
		response.sendRedirect("/mvc/member/list");
		
	}

}



