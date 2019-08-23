package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeJavaConfig {
	
	@Bean
	public FortuneService practiceFortuneService() {
		return new PracticeFortuneService();
	}
	
	@Bean
	public Coach basketballCoach() {
		return new BasketballCoach(practiceFortuneService());
	}

}
