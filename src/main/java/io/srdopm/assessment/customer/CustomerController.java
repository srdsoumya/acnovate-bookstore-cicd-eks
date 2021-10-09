package io.srdopm.assessment.customer;

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
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	// Get all the customers who own the book by ISBN passed in path
	@GetMapping("/owned/{isbn}")
	public List<Customer> getAllCustomerOwnIsbn(@PathVariable Integer isbn) {
		return customerService.getAllCustomerOwnIsbn(isbn);
	}

	// Post customer with array of books he owns.
	@PostMapping("/customer")
	public CustomerBooks addCustomerBooks(@RequestBody CustomerBooks customerBooks) {
		return customerService.saveCustomerBooks(customerBooks);
	}

	// Down below development purpose
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	// Get all the customers who own the book by ISBN passed in path
	@PostMapping("/api_uri/{account_uid}")
	public String testTerraform(@PathVariable String account_uid) {
		return new String("{\"region\": \"g\",\"access_key\": \"dfg\",\"secret_key\": \"gdg\"}");
	}
}
