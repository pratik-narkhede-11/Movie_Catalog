package com.pratik.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.model.Rating;
import com.pratik.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatindsDataResource 
{
	@RequestMapping("/movie/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("1", 4),
				new Rating("2", 6),
				new Rating("3", 3)
		);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
