package com.cts.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cast")
public class Cast implements Comparable<Cast> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long castId;
	@ManyToOne
	@JoinColumn(name="mid")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name="aid")
	private Artist artist;
	private String role;
	
	public Cast() {
		
	}

	public Cast(Movie movie, Artist artist, String role) {
		super();
		this.movie = movie;
		this.artist = artist;
		this.role = role;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int compareTo(Cast o) {
		return this.castId==null?1:this.castId.compareTo(o.castId);
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", movie=" + movie + ", artist=" + artist + ", role=" + role + "]";
	}
	
	
}
