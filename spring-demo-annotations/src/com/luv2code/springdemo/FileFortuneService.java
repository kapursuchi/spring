package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String filePath = "C:\\Users\\suchi\\Desktop\\fortune-data.txt";
	private List<String> theFortunes;
	private Random random = new Random();
	
	
	public FileFortuneService() {
		//System.out.println(">> FileFortuneService: inside default constructor");

	}
	
	@PostConstruct
	public void loadFortunesFromFile() {
		//System.out.println(">> FileFortuneService: inside loadFortunesFromFile()");
		
		//read fortunes from file
		File file = new File(filePath);
		
		theFortunes = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(
				new FileReader(file))) {

			String line;

			while ((line = br.readLine()) != null) {
				theFortunes.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		
		int index = random.nextInt(theFortunes.size());
		
		return theFortunes.get(index);
	}
	
	
	@PreDestroy
	public void doMyCleanupStuff() {
		
		//System.out.println(">> FileFortuneService: inside doMyCleanupStuff()");
	}


}
