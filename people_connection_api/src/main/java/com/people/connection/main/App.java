package com.people.connection.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.people.connection")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
