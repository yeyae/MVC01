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
		// ����� ��ȭ ��� �������� �̵�
		String url = "movie/movieWrite.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȭ ������ DB�� ����ϴ� ��
		req.setCharacterEncoding("utf-8");
		
		Movie movie = new Movie();
		
		movie.setTitle(req.getParameter("title"));
		movie.setDirector(req.getParameter("director"));
		movie.setPrice(Integer.parseInt(req.getParameter("price")));
		movie.setSynopsis(req.getParameter("synopsis"));
		
		// ���� ���ε� ó��
		// ������ ��Ʈ(Part)�� ������ �ȴ�
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			// ��¥ �������� Ȯ��
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				// ���� �̸� ��������
				System.out.println(fileName);
				// ���� �����ؼ� ����
				// ������Ʈ ���� images ��� ã��
				String path = req.getServletContext().getRealPath("/images");
				// ������Ʈ ���� images ���� �ؿ� ���� �����ϵ��� �ϱ�
				
				if(part.getSize() > 0) {
					part.write(path + "/" + fileName);
					// ���� �̸� movie�� poster�� ����
					movie.setPoster(fileName);
				}
				// ������ �����ϱ� db�� ����
				MovieDao.getInstance().insertMovie(movie);
			}
		}
		resp.sendRedirect("movieList.do");
	}
	
}
