package com.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.notification.constants.ApiConstants;
import com.twilio.Twilio;

@SpringBootApplication 
@EnableJpaRepositories("com.notification.repositories")

public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
	static {
	      Twilio.init(ApiConstants.ACCOUNT_SID, ApiConstants.AUTH_TOKEN);
	   }
}
