package com.globalin.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.globalin.dao.MovieDao;
import com.globalin.model.Movie;

public class MovieWrite extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 여기는 영화 등록 페이지로 이동
		String url = "movie/movieWrite.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 영화 정보를 DB에 등록하는 일
		req.setCharacterEncoding("utf-8");
		
		Movie movie = new Movie();
		
		movie.setTitle(req.getParameter("title"));
		movie.setDirector(req.getParameter("director"));
		movie.setPrice(Integer.parseInt(req.getParameter("price")));
		movie.setSynopsis(req.getParameter("synopsis"));
		
		// 파일 업로드 처리
		// 파일은 파트(Part)로 전송이 된다
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			// 진짜 파일인지 확인
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				// 파일 이름 가져오기
				System.out.println(fileName);
				// 파일 복사해서 저장
				// 프로젝트 안의 images 경로 찾기
				String path = req.getServletContext().getRealPath("/images");
				// 프로젝트 안의 images 폴더 밑에 파일 저장하도록 하기
				
				if(part.getSize() > 0) {
					part.write(path + "/" + fileName);
					// 파일 이름 movie의 poster로 저장
					movie.setPoster(fileName);
				}
				// 파일이 맞으니까 db에 저장
				MovieDao.getInstance().insertMovie(movie);
			}
		}
		resp.sendRedirect("movieList.do");
	}
	
}
