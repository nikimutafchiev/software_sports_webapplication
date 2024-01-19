package com.example.application;

import application.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MainApplicationTests.class)
class MainApplicationTests {
	UserInterface console = UserInterface.getSingleton_instance();
	@Test
	void testAddTeam(){
		try{
			Assertions.assertEquals(0, UserInterface.getSingleton_instance().addTeam("niki","sofia",new int[]{}));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void testAddPlayer(){
		try{
		Assertions.assertEquals(0, UserInterface.getSingleton_instance().addPlayer("niki",24, 2));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
