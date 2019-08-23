package com.luv2code.springdemo;

public class BasketballCoach implements Coach {

	
	private FortuneService fortuneService;
	
	public BasketballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {

		return "Practice freethrows and layups.";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
