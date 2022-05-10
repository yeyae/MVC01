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
		// 파라미터에서 영화 코드값 받아오기
		int code = Integer.parseInt(req.getParameter("code"));
		
		// movie dao 객체 생성해서 delete 문 실행하기
		MovieDao dao = MovieDao.getInstance();
		dao.deleteMovie(code);
		
		// movieList.jsp 로 이동하기
		resp.sendRedirect("movieList.do");
	}
	
}
