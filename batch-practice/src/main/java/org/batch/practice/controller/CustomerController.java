package org.batch.practice.controller;

import javax.validation.Valid;

import org.batch.practice.amq.Producer;
import org.batch.practice.model.Customer;
import org.batch.practice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	Producer producer;
	
	@PostMapping("/post-customer")
	public String postCustomer(@Valid @RequestBody Customer customer) {
		System.out.println("########## In postCustomer");
		String message = producer.publish(customer);
		return message;
	}

	@GetMapping("/findall")
	public String findAll() {

		String result = "";

		for (Customer cust : repository.findAll()) {
			result += cust + "</br>";
		}

		return result;
	}

	@GetMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}

	@GetMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (Customer cust : repository.findByName(name)) {
			result += cust + "</br>";
		}

		return result;
	}
}