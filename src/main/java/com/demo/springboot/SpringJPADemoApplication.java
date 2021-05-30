package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJPADemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJPADemoApplication.class, args);
	}

}
