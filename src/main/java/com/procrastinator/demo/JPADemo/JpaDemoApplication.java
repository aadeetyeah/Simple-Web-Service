package com.procrastinator.demo.JPADemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

}

/*
* application.properties will have all the details regarding configuration.
* i.e. configuration related to Database,Redis,Kafka.
* This file can be of two types.
* Either application.properties or as YAML file also.
*
* So we don;t need to create a JDBC class
* we can do all of that in application.properties file*/
