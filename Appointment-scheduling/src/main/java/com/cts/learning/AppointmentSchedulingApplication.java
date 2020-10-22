package com.cts.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.cts.learning.repository")
public class AppointmentSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulingApplication.class, args);
	}

}
