package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cognizant.controller","com.cognizant.swaggerCongifuration"})
public class RestPrducts1Application {
     
	public static void main(String[] args) {
		SpringApplication.run(RestPrducts1Application.class, args);
	}

}
