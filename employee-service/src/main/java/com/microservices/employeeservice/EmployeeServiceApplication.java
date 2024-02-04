package com.microservices.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	/**
	 * create bean for WebClient
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
	 */

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
