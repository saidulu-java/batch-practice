package org.batch.practice.repository;

import java.util.List;

import org.batch.practice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByName(String name);
}
