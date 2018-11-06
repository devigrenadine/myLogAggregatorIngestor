package org.mine;

import javax.annotation.PreDestroy;

import org.mine.thriftServer.LogServiceThriftServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class LogServiceServerThriftApp is the entry point for our Thrift Server
 * application
 */
@SpringBootApplication
public class LogServiceServerThriftApp implements CommandLineRunner {

	/** The log service thrift server. */
	@Autowired
	LogServiceThriftServer logServiceThriftServer;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(LogServiceServerThriftApp.class, args);
	}

	/** 
	 * Run.
	 *
	 * @param strings the strings
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		logServiceThriftServer.start();
	}

	/**
	 * Clean up actions.
	 */
	@PreDestroy
	public void cleanup() {
		logServiceThriftServer.stop();
	}
}
