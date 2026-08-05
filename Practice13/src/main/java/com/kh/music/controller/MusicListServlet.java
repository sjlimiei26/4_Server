package com.kh.music.controller;

import java.io.IOException;
import java.util.List;

import com.kh.music.model.dao.MusicDAO;
import com.kh.music.model.dto.MusicDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MusicListServlet
 */
@WebServlet("/list")
public class MusicListServlet extends HttpServlet {
	private MusicDAO dao = new MusicDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MusicDTO> list = dao.findAll();
		
		request.setAttribute("musicList", list);
		request.getRequestDispatcher("/WEB-INF/views/list.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
