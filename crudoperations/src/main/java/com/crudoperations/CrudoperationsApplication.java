package com.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"crudoperations.Controller"})
public class CrudoperationsApplication {

	public static void main(String[] args) {
        SpringApplication.run(CrudoperationsApplication.class, args);

	}
	
}
