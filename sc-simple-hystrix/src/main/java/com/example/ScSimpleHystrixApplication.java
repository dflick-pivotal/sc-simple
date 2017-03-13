package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableHystrixDashboard
@Controller
public class ScSimpleHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScSimpleHystrixApplication.class, args);
	}
	
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

}
