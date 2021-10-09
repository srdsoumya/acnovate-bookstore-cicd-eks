package io.srdopm.assessment.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.srdopm.assessment.book.Book;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer customer_no; 
	private String customer_name;
	private Integer isbn;
	@OneToMany(mappedBy = "isbn")
	List<Book> books = new ArrayList<>();
	
	public Customer() {}
	public Customer(Integer customer_no, String customer_name, Integer isbn) {
		super();
		this.customer_no = customer_no;
		this.customer_name = customer_name;
		this.isbn = isbn;
	}

	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_no=" + customer_no + ", customer_name=" + customer_name + ", isbn="
				+ isbn + "]";
	}
	
}
