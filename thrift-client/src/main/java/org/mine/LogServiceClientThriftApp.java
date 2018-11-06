package org.mine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class LogServiceClientThriftApp is the entry point class to our
 * application.
 *
 * @author evi
 */
@SpringBootApplication
@EnableScheduling
public class LogServiceClientThriftApp implements CommandLineRunner {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(LogServiceClientThriftApp.class, args);
	}

	public void run(String... strings) throws Exception {
 
	}
}
