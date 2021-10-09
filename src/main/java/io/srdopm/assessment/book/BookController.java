package io.srdopm.assessment.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookController {
	@Autowired
	private BookService bookService;

	// Get all books owned by the customer no. passed in path params.
	@GetMapping("/owns/{customerNo}")
	public List<Book> getAllBookByCustomerNo(@PathVariable Integer customerNo) {
		return bookService.getAllBookByCustomerNo(customerNo);
	}
	
	// Down below development purpose
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PostMapping("/books")
	public List<Book> addBooks(@RequestBody List<Book> books) {
		return bookService.addBooks(books);
	}

	@GetMapping("/books")
	public List<Book> getAllBook() {
		return bookService.retriveAllBook();
	}

}
