package com.cts.jpahibdemo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	private String title;

	@OneToMany(mappedBy = "movie")
	private Set<Cast> cast;

	public Movie() {
	}

	public Movie(Long movieId, String title) {
		super();
		this.movieId = movieId;
		this.title = title;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Cast> getCast() {
		return cast;
	}

	public void setCast(Set<Cast> cast) {
		this.cast = cast;
	}

}
