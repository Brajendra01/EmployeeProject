package com.employee.empdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmpdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpdemoApplication.class, args);
	}
}
