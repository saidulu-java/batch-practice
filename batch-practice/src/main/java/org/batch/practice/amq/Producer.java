package org.batch.practice.amq;
import org.batch.practice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

//@RestController
@Component
public class Producer {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

//    @GetMapping("publish/{msg}")
//    public String publish(@PathVariable("msg") final String msg){
//        jmsTemplate.convertAndSend(queue,msg);
//        return "Your message <b>"+msg+"</b> published successfully";
//    }
    
    public String publish(Customer customer){
    	System.out.println("########## In publish");
        jmsTemplate.convertAndSend(queue,customer);
        return "Customer "+customer.getName()+" published successfully";
    }
}