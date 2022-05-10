package com.globalin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.MovieDao;
import com.globalin.model.Movie;

@WebServlet("/movieList.do")
public class MovieList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// do ~ 하다
		// do movieList 
		// do movieDelete ==> /movieList.do frontcontroller 패턴
		
		MovieDao dao = MovieDao.getInstance();
		
		List<Movie> list = dao.selecAllMovies();
		
		req.setAttribute("list", list);
		
		String url = "movie/movieList.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
