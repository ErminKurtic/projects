package com.example.RockPaperScissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RockPaperScissorsTest {

    Game game;
    private Player mockPlayer;
    private Computer mockComputer;

    @BeforeEach
    void setUp() {
        mockPlayer = mock(Player.class);
        mockComputer = mock(Computer.class);
        game = new Game(mockPlayer, mockComputer);
    }

    @Test
    void test_mock_player_wins() {
        when(mockPlayer.getScore()).thenReturn(0, 3);
        when(mockPlayer.playerInput()).thenReturn("PAPER");
        when(mockComputer.computerMove()).thenReturn("ROCK");

        game.startGame();

        verify(mockPlayer, times(1)).incrementScore();
        verify(mockComputer, times(0)).incrementScore();
        assertEquals(3, mockPlayer.getScore());

    }

    @Test
    void test_mock_computer_wins() {
        when(mockComputer.getScore()).thenReturn(0, 3);
        when(mockPlayer.playerInput()).thenReturn("PAPER");
        when(mockComputer.computerMove()).thenReturn("SCISSORS");

        game.startGame();

        verify(mockPlayer, times(0)).incrementScore();
        verify(mockComputer, times(1)).incrementScore();
        assertEquals(3, mockComputer.getScore());
    }


    // - Test of while-loop if player and computer choose same choice everytime
    // - Commented out because of infinity loop during test
    // - Tested to see if logic and game as a whole works
    // - YES IT DOES!

    /*@Test
    void test_mock_draw() {
        // Given
        when(mockPlayer.playerInput()).thenReturn("ROCK");
        when(mockComputer.computerMove()).thenReturn("ROCK");

        // When
        game.startGame();

        // Then
        verify(mockPlayer, times(0)).incrementScore();
        verify(mockComputer, times(0)).incrementScore();
        assertEquals(0,mockComputer.getScore());
        assertEquals(0,mockPlayer.getScore());
    }*/

}