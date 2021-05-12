package com.sharedexpenses;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.SharedExpensesDAO;
import com.sharedexpenses.repository.mysqlImp.FriendsGroupMybatisRepository;
import com.sharedexpenses.repository.mysqlImp.MysqlDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication
@ComponentScan(value = "com.sharedexpenses")
public class SharedExpensesApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args) {
		SpringApplication.run(SharedExpensesApplication.class, args);
	}


}
