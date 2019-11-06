package org.batch.practice.amq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms
public class JMSConfig {

	@Value("active-mq-url")
	private String activeMqUrl;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("boot-amq");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFatory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin",activeMqUrl);
		factory.setBrokerURL(activeMqUrl);
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFatory());
	}
}