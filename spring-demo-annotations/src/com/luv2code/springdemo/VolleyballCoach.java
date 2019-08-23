package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	
	//Step 2: create a constructor in your class for injections
	//Spring will scan for a component that implements FortuneService interface
	// ex: HappyFortuneService will meet the requirement
	
	
	public VolleyballCoach() {
		
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice spiking and passes";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
