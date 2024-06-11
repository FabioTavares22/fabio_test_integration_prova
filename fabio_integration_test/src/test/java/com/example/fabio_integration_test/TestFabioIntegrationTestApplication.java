package com.example.fabio_integration_test;

import org.springframework.boot.SpringApplication;

public class TestFabioIntegrationTestApplication {

	public static void main(String[] args) {
		SpringApplication.from(FabioIntegrationTestApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
