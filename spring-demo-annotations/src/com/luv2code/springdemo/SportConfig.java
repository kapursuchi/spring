package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
// @ComponentScan("com.luv2code.springdemo") //give the package to start scanning
public class SportConfig {
	
	//define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	//define bean for our swim coach AND inject dependency
	@Bean 
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService()); // calling sad fortune service bean method
		//gives us reference based on bean scope
	}
		

}
