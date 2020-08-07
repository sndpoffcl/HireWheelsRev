package com.upgrad.HireWheelsRev;

import com.upgrad.HireWheelsRev.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HireWheelsRevApplication implements CommandLineRunner {

	@Autowired
	InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(HireWheelsRevApplication.class, args);
	}

	@Override
	public void run(String... arg0){
		initService.insertData();
	}

}
