package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeConfigJavaDemoApp {

	public static void main(String[] args) {

		//read the java config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(PracticeJavaConfig.class);
	
		
		//retrieve the bean
		Coach theCoach = context.getBean("basketballCoach", Coach.class);
		
		//call methods on it
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	
	
	}

}
