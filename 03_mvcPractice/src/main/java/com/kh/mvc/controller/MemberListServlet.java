package com.kh.mvc.controller;

import java.io.IOException;
import java.util.List;

import com.kh.mvc.model.MemberDAO;
import com.kh.mvc.model.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * * Controller : 브라우저의 요청을 받아 데이터를 준비하고 View 로 전달하는 역할(계층)
 * 
 * - 요청에 대한 처리 흐름 -
 * 
 * 	브라우저 요청 -> Controller(Servlet) -> Model(DAO) -> 결과를 request 담기
 * 			-> View(jsp)로 forward -> 화면에 표시됨
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DAO 를 통해서 DB에서 데이터를 조회
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.findAll();
		
		// 조회된 결과를(리스트) request 영역에 저장
		request.setAttribute("memberList", list);
		
		// * list.jsp 로 forward
		//   위치 => WEB-INF/views/member/list.jsp
		request.getRequestDispatcher("/WEB-INF/views/member/list.jsp")
			   .forward(request, response);

	}


}
