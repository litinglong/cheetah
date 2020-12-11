package com.ltl.matrix1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Matrix1Application {

	public static void main(String[] args) {
		SpringApplication.run(Matrix1Application.class, args);
	}

}
