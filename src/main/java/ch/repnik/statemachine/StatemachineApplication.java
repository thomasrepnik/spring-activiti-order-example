package ch.repnik.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class StatemachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatemachineApplication.class, args);
	}

}
