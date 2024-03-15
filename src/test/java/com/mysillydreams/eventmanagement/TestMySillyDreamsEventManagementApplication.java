package com.mysillydreams.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMySillyDreamsEventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(MySillyDreamsEventManagementApplication::main).with(TestMySillyDreamsEventManagementApplication.class).run(args);
	}

}
