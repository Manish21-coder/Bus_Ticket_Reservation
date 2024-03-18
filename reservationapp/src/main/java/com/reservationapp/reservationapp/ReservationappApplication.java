package com.reservationapp.reservationapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReservationappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationappApplication.class, args);
	}

	@Bean
	ModelMapper converter(){
		return new ModelMapper();
	}
}
