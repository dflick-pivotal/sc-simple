package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController

public class ScSimpleServiceApplication {

	@Autowired
	DiscoveryClient client;

	public static void main(String[] args) {
		SpringApplication.run(ScSimpleServiceApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		ServiceInstance localInstance = client.getLocalServiceInstance();
		return "Hello from: "+ localInstance.getServiceId();
	}

}