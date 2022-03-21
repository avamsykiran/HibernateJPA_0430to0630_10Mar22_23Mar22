package com.cts.jpahibdemo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;
	@Column(name = "anm")
	private String name;

	@OneToMany(mappedBy = "artist")
	private Set<Cast> cast;

	public Artist() {

	}

	public Artist(Long artistId, String name) {
		super();
		this.artistId = artistId;
		this.name = name;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cast> getCast() {
		return cast;
	}

	public void setCast(Set<Cast> cast) {
		this.cast = cast;
	}

}
