package com.ding.eureka.authenticating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaAuthenticatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAuthenticatingApplication.class, args);
	}
}
