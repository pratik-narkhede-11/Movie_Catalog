package com.pratik.model;

public class Rating 
{
	private String MovieId;
	private int rating;
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Rating(String movieId, int rating) {
		super();
		MovieId = movieId;
		this.rating = rating;
	}
	
	
}
