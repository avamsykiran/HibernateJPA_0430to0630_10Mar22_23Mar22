package com.cts.jpahibdemo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bid;
	private String title;
	private Double price;
	private LocalDate publishDate;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long bid, String title, Double price, LocalDate publishDate) {
		super();
		this.bid = bid;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate + "]";
	}
	
}
