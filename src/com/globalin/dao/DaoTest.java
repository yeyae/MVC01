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
		m.setTitle("������");
		m.setDirector("���¿�");
		m.setPrice(10000);
		m.setPoster("movie1.jpg");
		m.setSynopsis("�Ŵ��� ������ ���� ������ ����� ���� ������.");
		
		dao.insertMovie(m);

	}
	
}
