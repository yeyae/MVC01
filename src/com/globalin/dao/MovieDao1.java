package com.globalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globalin.model.Movie;
import com.globalin.util.DBManager;

public class MovieDao1 {
	
	
	// 영화정보 모두 가져오기
	// selectAllMovies()
	public List<Movie> selectAllMovies() {
		String sql = "select * from movie order by code desc";
		List<Movie> result = new ArrayList<Movie>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setCode(rs.getInt("code"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				movie.setDirector(rs.getString("director"));
				movie.setSynopsis(rs.getString("synopsis"));
				movie.setPoster(rs.getString("poster"));
				result.add(movie);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}
	
	// 영화 하나 가져오기 
	public Movie selectMovieByCode(int code) {
		String sql = "select * from movie where code = ?";
		Movie result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new Movie();
				result.setCode(rs.getInt("code"));
				result.setTitle(rs.getString("title"));
				result.setPrice(rs.getInt("price"));
				result.setDirector(rs.getString("director"));
				result.setPoster(rs.getString("poster"));
				result.setSynopsis(rs.getString("synopsis"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}
	
	public int insertMovie(Movie movie) {
		String sql = "insert into movie values(movie_seq.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getPoster());
			pstmt.setString(5, movie.getSynopsis());
			
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}
	
	public int updateMovie(Movie movie) {
		String sql = "update movie set title=?,price=?,director=?,poster=?,synopsis=?"
				+ " where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getPrice());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getPoster());
			pstmt.setString(5, movie.getSynopsis());
			pstmt.setInt(6, movie.getCode());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}
	
	public int deleteMovie(int code) {
		String sql = "delete from movie where code = ?";
		Connection conn = null;
		PreparedStatement pstmt =null;
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}
	
}
