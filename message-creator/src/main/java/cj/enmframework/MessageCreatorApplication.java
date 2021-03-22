package cj.enmframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MessageCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageCreatorApplication.class, args);
	}

}
