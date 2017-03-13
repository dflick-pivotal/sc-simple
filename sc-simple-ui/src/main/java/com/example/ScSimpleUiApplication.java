package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@EnableFeignClients
public class ScSimpleUiApplication {

	@Autowired
	HelloClient client;

	public static void main(String[] args) {
		SpringApplication.run(ScSimpleUiApplication.class, args);
	}

	@RequestMapping("/")
	@HystrixCommand(fallbackMethod = "fallback")
	public String hello() {
		return client.hello();
	}

	@FeignClient(name = "service")
	interface HelloClient {
		@RequestMapping(value = "/", method = RequestMethod.GET)
		String hello();
	}
		
    String fallback() {
        return "This is the hystrix fallback!!!";
    }
}
