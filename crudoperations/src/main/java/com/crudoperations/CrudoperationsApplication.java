package com.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.crudoperations.Model")
public class CrudoperationsApplication {

	public static void main(String[] args) {
        SpringApplication.run(CrudoperationsApplication.class, args);

	}

}
