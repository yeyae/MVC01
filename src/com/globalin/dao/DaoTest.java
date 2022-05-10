package com.globalin.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import com.globalin.model.Movie;

public class DaoTest {
	
	@Test
	public void daoTest() {
		MovieDao dao = MovieDao.getInstance();
		
		Movie m = new Movie();
		m.setTitle("베를린");
		m.setDirector("류승완");
		m.setPrice(10000);
		m.setPoster("movie1.jpg");
		m.setSynopsis("거대한 국제적 음모가 숨겨진 운명의 도시 베를린.");
		
		dao.insertMovie(m);

	}
	
}
