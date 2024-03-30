package com.mysillydreams.eventmanagement;

import com.mysillydreams.eventmanagement.configuration.TwilioOtpConfiguration;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySillyDreamsEventManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(MySillyDreamsEventManagementApplication.class, args);
	}

}
