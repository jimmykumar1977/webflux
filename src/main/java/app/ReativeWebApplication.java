package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReativeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReativeWebApplication.class, args);

	}

}
