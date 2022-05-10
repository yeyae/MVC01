package com.globalin.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.globalin.dao.MovieDao;
import com.globalin.model.Movie;

public class MovieUpdate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "movie/movieUpdate.jsp";
		
		int code = Integer.parseInt(req.getParameter("code"));
		
		MovieDao dao = MovieDao.getInstance();
		// code 로 movie정보 하나 가져오기
		Movie movie = dao.selectMovieByCode(code);
		req.setAttribute("movie", movie);
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 파라미터에서 업데이트할 movie 정보를 가져오면 된다.
		Movie movie = new Movie();
		movie.setTitle(req.getParameter("title"));
		movie.setDirector(req.getParameter("director"));
		movie.setPrice(Integer.parseInt(req.getParameter("price")));
		movie.setCode(Integer.parseInt(req.getParameter("code")));
		movie.setSynopsis(req.getParameter("synopsis"));
		
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			// 파일인 파트만 골라낸다.
			// 파트도 parameter 같이 날아온다.
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				// 이부분 에서 파일 이름을 가져옴
				String fileName = part.getSubmittedFileName();
				System.out.println(fileName);
				if(part.getSize() > 0) {
					String path = req.getServletContext().getRealPath("/images");
					
					// 실제로 파일을 저장
					part.write(path + "/" + fileName);
					movie.setPoster(fileName);
				}
			}
		}
		
		MovieDao dao = MovieDao.getInstance();
		dao.updateMovie(movie);
		
		resp.sendRedirect("movieList.do");
	}
}
