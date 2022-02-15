package com.example.RockPaperScissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ClassTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new Player(), new Computer());
    }


    @Test
    void test_player_choice_in_game_success() {

        game.player.setChoice("ROCK");

        assertEquals("ROCK", game.player.getChoice());
    }


    @Test
    void test_player_vs_computer_with_random_outcome() {

        game.player.setChoice("ROCK");

        game.computer.computerMove();

        assertEquals(game.player.getChoice(), game.computer.getComputerChoice());
    }

    @Test
    void test_player_getScore() {
        game.player.incrementScore();

        assertEquals(1, game.player.getScore());
    }

    @Test
    void test_computer_getScore() {
        game.computer.incrementScore();

        assertEquals(1, game.computer.getScore());
    }

    // Todo: Test for playerInput using Scanner! NOT FINISHED!
	/*@Test
	void test_player_input() {

		Player mockPlayer = mock(Player.class);
		//Scanner mockScanner = mock(Scanner.class);
		//String input = mockPlayer.setChoice("PAPER");

		when(mockPlayer.playerInput()).thenReturn("PAPER");

		*//*when(mockScanner.nextLine()).thenReturn("PAPER");
		when(mockPlayer.playerInput()).thenReturn(String.valueOf(mockScanner));*//*

		assertEquals("PAPER", mockPlayer.getChoice());

	}*/
}
