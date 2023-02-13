package com.ezen.springmvc.model;

import org.springframework.stereotype.Repository;

// 스프링이 수거해 갈 수 있도록 어노테이션으로 표시를 해둔다..
@Repository
public class Book {

	private String book_name;
	private String author;
	private String pages;
	
	public Book() {}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}
	
	
}
