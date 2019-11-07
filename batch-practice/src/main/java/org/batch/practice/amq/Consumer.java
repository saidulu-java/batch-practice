package org.batch.practice.amq;
import org.batch.practice.model.Customer;
import org.batch.practice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@Autowired
	CustomerRepository customerRepository;

    @JmsListener(destination = "boot-amq")
    public void listener(Customer customer){
        System.out.println("########## Received Message : "+customer);
        customerRepository.save(customer);
        
    }
}