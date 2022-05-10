package com.globalin.model;

public class Movie {
	private int code, price;
	private String title,director, poster, synopsis;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	@Override
	public String toString() {
		return "Movie [code=" + code + ", price=" + price + ", title=" + title + ", director=" + director + ", poster="
				+ poster + ", synopsis=" + synopsis + "]";
	}
}
