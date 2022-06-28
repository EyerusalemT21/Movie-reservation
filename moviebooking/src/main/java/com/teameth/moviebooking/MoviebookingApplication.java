package com.teameth.moviebooking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.teameth.moviebooking.repository")
@SpringBootApplication
public class MoviebookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviebookingApplication.class, args);
	}

}
