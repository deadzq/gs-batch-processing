package com.example.batchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Although batch processing can be embedded in web apps and WAR files,
 * the simpler approach demonstrated below creates a standalone application.
 * You package everything in a single, executable JAR file,
 * driven by a good old Java main() method.
 *
 * springboot
 */
@SpringBootApplication
public class BatchProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingApplication.class, args);
	}

}
