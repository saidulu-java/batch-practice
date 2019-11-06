package org.batch.practice.controller;

import javax.validation.Valid;

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

	@PostMapping("/save")
	public String process(@Valid @RequestBody Customer customer) {

		/*
		 * repository.save(Arrays.asList(new Customer("Jack", 20, "SAVING", 20000D)));
		 */

		repository.save(customer);
		return "Customer details saved successfully !";
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