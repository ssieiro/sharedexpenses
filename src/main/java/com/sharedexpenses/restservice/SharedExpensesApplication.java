package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.FriendsGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@ComponentScan(value = "com.sharedexpenses")
public class SharedExpensesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SharedExpensesApplication.class, args);

		FriendsGroup myGroupOfFriends = new FriendsGroup("Mi Grupo");
		myGroupOfFriends.addFriend("Ramón");
		myGroupOfFriends.addFriend("María");
		myGroupOfFriends.addFriend("Jesús");
		myGroupOfFriends.addPayment("Cena", BigDecimal.valueOf(10), "Ramón", LocalDateTime.now());
		myGroupOfFriends.addPayment("Cena", BigDecimal.valueOf(50), "María", LocalDateTime.now());

		//System.out.println("totalAmount: = " + myGroupOfFriends.calculateTotalAmount());
		//myGroupOfFriends.printTotalDebts();


	}

}
