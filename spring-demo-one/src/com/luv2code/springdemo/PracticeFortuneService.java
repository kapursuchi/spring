package com.luv2code.springdemo;

import java.util.Random;

public class PracticeFortuneService implements FortuneService {

	private String[] fortuneArray = {"Fortune 1", "Fortune 2", "Fortune 3"};
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int fortuneNumber = random.nextInt(3);
		return fortuneArray[fortuneNumber];
	}

}
