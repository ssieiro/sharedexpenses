package com.sharedexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(value = "com.sharedexpenses")
public class SharedExpensesApplication {


	public static void main(String[] args) {

		SpringApplication.run(SharedExpensesApplication.class, args);

	}

}
