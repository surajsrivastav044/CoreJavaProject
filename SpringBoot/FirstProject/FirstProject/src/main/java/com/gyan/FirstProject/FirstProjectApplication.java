package com.gyan.FirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication {

	private Notification notification;

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

	public void run(){
		notification.notifyMessage();
	}

}
