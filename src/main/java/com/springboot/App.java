package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		for(int i=0; i<2; i++) {
			System.out.println();
		}
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(context.getBeansOfType(Runnable.class));
		
		for(int i=0; i<2; i++) {
			System.out.println();
		}
	}

}
