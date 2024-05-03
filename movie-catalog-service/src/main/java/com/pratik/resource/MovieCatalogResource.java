package com.pratik.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pratik.model.CatalogItem;
import com.pratik.model.Movie;
import com.pratik.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;              //Synchronous  API calls              -- Depricated in future
	
//	@Autowired
//	WebClient.Builder builder;                      //ASynchronous API calls
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{	
		
		UserRating ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/rating/user/"+userId, UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(),Movie.class);
			return new CatalogItem(movie.getName(),"Test", rating.getRating());
		}).collect(Collectors.toList());

/*		return ratings.stream().map(rating -> {
			
			Movie movie = builder.build()
				.get()
				.uri("http://localhost:8081/movies/"+rating.getMovieId())
				.retrieve()
				.bodyToMono(Movie.class)
				.block();
			
			return new CatalogItem(movie.getName(),"Test", rating.getRating());
		}).collect(Collectors.toList());
*/		
	}
}
