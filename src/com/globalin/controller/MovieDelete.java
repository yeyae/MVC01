package com.globalin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.MovieDao;

@WebServlet("/moviedelete.do")
public class MovieDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �Ķ���Ϳ��� ��ȭ �ڵ尪 �޾ƿ���
		int code = Integer.parseInt(req.getParameter("code"));
		
		// movie dao ��ü �����ؼ� delete �� �����ϱ�
		MovieDao dao = MovieDao.getInstance();
		dao.deleteMovie(code);
		
		// movieList.jsp �� �̵��ϱ�
		resp.sendRedirect("movieList.do");
	}
	
}
