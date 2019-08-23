package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Step 2: add the @Component annotation to java class
//Spring will automatically register this bean 
//default bean id = tennisCoach

@Component
public class TennisCoach implements Coach {

	//Field injection
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff()");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
	}
	
	
	/*---------------Constructor injection----------------
	 *
	//Step 2: create a constructor in your class for injections
	//Spring will scan for a component that implements FortuneService interface
	// ex: HappyFortuneService will meet the requirement
	
	
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	/*-----------------Setter Injection-----------------
	 * 
	
	//define a setter method -- can do injection on any method using @Autowired
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");

		fortuneService = theFortuneService; 
	}
	*/
	
	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
