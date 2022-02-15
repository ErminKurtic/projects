package com.example.RockPaperScissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RockPaperScissors {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissors.class, args);
		Game game = new Game(new Player(), new Computer());
		game.startGame();
	}
}
