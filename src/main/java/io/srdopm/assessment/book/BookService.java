package io.srdopm.assessment.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	public List<Book> retriveAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public List<Book> getAllBookByCustomerNo(Integer customer_no) {
		// TODO Auto-generated method stub
		return bookRepository.findByCustomer_no(customer_no);
	}

	public List<Book> addBooks(List<Book> books) {
		// TODO Auto-generated method stub
		return bookRepository.saveAll(books);
	}

}
