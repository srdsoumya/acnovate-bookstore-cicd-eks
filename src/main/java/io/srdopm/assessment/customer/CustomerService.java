package io.srdopm.assessment.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer custmer) {
		// TODO Auto-generated method stub
		return customerRepository.save(custmer);
	}

	public List<Customer> getAllCustomerOwnIsbn(Integer isbn) {
		// TODO Auto-generated method stub
		return customerRepository.findByIsbn(isbn);
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public CustomerBooks saveCustomerBooks(CustomerBooks customerBooks) {
		// TODO Auto-generated method stub
		List<Customer> blist= new ArrayList<>();
		int no = customerBooks.getCustomer().getCustomer_no();
		String name = customerBooks.getCustomer().getCustomer_name();
		for(io.srdopm.assessment.book.Book book:customerBooks.getBook_list()) {
			blist.add(new Customer(no, name, book.getIsbn()));
		}
		customerRepository.saveAll(blist);
		return customerBooks;
		
	}

}
