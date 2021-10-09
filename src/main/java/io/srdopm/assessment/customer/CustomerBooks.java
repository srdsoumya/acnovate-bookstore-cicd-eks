package io.srdopm.assessment.customer;

import java.util.List;

import io.srdopm.assessment.book.Book;

public class CustomerBooks {
	private Customer customer;
	private List<Book> book_list;
	
	public CustomerBooks() {}
	public CustomerBooks(Customer customer, List<Book> book_list) {
		super();
		this.customer = customer;
		this.book_list = book_list;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Book> getBook_list() {
		return book_list;
	}
	public void setBook_list(List<Book> book_list) {
		this.book_list = book_list;
	}
	

}
