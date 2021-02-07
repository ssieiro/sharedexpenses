package es.ssieiro.sharedexpenses.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "es.ssieiro.sharedexpenses")
public class SharedexpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedexpensesApplication.class, args);
	}

}
