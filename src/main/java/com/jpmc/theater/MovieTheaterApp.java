package com.jpmc.theater;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTheaterApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieTheaterApp.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}
}
