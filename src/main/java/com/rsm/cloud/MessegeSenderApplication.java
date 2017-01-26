package com.rsm.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;


@SpringBootApplication
@EnableBinding(Source.class)
public class MessegeSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessegeSenderApplication.class, args);
	}
	
	@InboundChannelAdapter(Source.OUTPUT)
	public Greeting getMessage() {
		Greeting greeting = new Greeting();
		greeting.setGreeting("Helloo " + System.currentTimeMillis());
		
		return greeting;
	}
	
	
	/*@InboundChannelAdapter(Source.OUTPUT)
	public String getMessage() {
		
		return "hello  " + System.currentTimeMillis();
	}*/
}
