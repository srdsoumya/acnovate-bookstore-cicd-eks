package io.srdopm.assessment.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer isbn; 
	private String bookname;
	private String author;
	
	public Book(){}
	public Book(int isbn, String bookname, String author) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookname=" + bookname + ", author=" + author + "]";
	}
}
