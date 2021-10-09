package io.srdopm.assessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.srdopm.assessment.book.Book;
import io.srdopm.assessment.book.BookController;
import io.srdopm.assessment.customer.Customer;
import io.srdopm.assessment.customer.CustomerBooks;
import io.srdopm.assessment.customer.CustomerController;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AcnovateBookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	@Autowired
	private CustomerController customerController;

	
	
	@Test
	@Order(1)
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(customerController).isNotNull();
	}
	
	//Required* sample book data
	@Test
	@Order(2)
	void addBooksTest() {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Testaments", "Margaret Atwood"));
		books.add(new Book(2, "The Overstory", "Richard Powers"));
		books.add(new Book(3, "Mind-Master", "Viswanathan Anand and Susan Ninan"));
		books.add(new Book(4, "Srdopm", "Soumya Ranjan Das"));
		bookController.addBooks(books);
		assertNotNull(bookController.getAllBook());
	}
	
	// 1. GET /owned/{isbn} : Get all the customers who own the book by ISBN passed in path
	// ISBN = 3 to only mapped to 102, "Mr. Customer Two"
	@Test
	@Order(4)
	void getAllCustomersWhoOwnTheBookByISBN(){
		CustomerBooks customerBooks = new CustomerBooks();
		List<Book> books = new ArrayList<>();
		books.add(new Book(2, "The Overstory", "Richard Powers"));
		books.add(new Book(3, "Mind-Master", "Viswanathan Anand and Susan Ninan"));
		books.add(new Book(4, "Srdopm", "Soumya Ranjan Das"));
		
		customerBooks.setCustomer(new Customer(102, "Mr. Customer Twno", 0));
		customerBooks.setBook_list(books);
		customerController.addCustomerBooks(customerBooks);
		
		// Get all the customers who own the book by ISBN passed 3 in path params.
		assertEquals(1,customerController.getAllCustomerOwnIsbn(3).size());
	}
	
	// 2. GET /owns/{customerNo}: Get all books owned by the customer no. passed in path params.
	// 3. POST /customer : Post customer with array of books he owns.
	// Customer no = 101
	@Test
	@Order(3)
	void postCustomerWithArrayOfBooksAndGetAllBooksOwnedByCustomerNo(){
		CustomerBooks customerBooks = new CustomerBooks();
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Testaments", "Margaret Atwood"));
		books.add(new Book(2, "The Overstory", "Richard Powers"));
		
		customerBooks.setCustomer(new Customer(101, "Mr. Customer One", 0));
		customerBooks.setBook_list(books);
		
		// Post customer with array of books he owns
		customerController.addCustomerBooks(customerBooks);
		
		// Get all books owned by the customer no. passed in path params.
		List<Book> actual_books = bookController.getAllBookByCustomerNo(101);
		
		assertEquals(books.size(),actual_books.size());
		assertThat(books).hasSameSizeAs(actual_books);
	}
	

	

}
