package com.ding.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class MicroserviceHystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHystrixTurbineApplication.class, args);
	}
}
