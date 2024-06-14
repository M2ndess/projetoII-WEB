package com.proj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"entity"}) // add this so the spring boot context knows where to look for entities
public class Proj2webApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj2webApplication.class, args);
	}

}
