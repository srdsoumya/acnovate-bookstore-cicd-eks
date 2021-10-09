package io.srdopm.assessment.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByIsbn(Integer isbn);

}
