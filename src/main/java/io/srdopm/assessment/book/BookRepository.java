package io.srdopm.assessment.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("from Book b inner join Customer c on b.isbn = c.isbn where c.customer_no=?1")
	List<Book> findByCustomer_no(Integer customer_no);
	
}
