package com.example.application;

import application.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MainApplicationTests.class)
class MainApplicationTests {
	@Test
	void testViewTeams(){
		try{
			UserInterface.getSingleton_instance().viewAllTeams();
		}catch(Exception e){
			Assertions.fail("Test failed");
		}
	}

	@Test
	void testViewPlayers(){
		try{
			UserInterface.getSingleton_instance().viewAllPlayers();
		}catch(Exception e){
			Assertions.fail("Test failed");
		}
	}

	@Test
	void testViewGames(){
		try{
			UserInterface.getSingleton_instance().viewAllGames();
		}catch(Exception e){
			Assertions.fail("Test failed");
		}
	}
}
