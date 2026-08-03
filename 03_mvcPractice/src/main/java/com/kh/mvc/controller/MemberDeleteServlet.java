package com.kh.mvc.controller;

import java.io.IOException;

import com.kh.mvc.model.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDAO dao = new MemberDAO();
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 추출
		int id = Integer.parseInt( request.getParameter("id") );
		
		// dao 를 통해 삭제 처리
		dao.deleteById(id);
		
		// 목록 페이지로 리다이렉트
		response.sendRedirect("/mvc/member/list");
	}

}
