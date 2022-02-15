package com.example.RockPaperScissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RoundWinnerTest {

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
    void test_paper_vs_rock() {
        when(mockPlayer.getChoice()).thenReturn("PAPER");
        when(mockComputer.getComputerChoice()).thenReturn("ROCK");

        game.getRoundWinner("PAPER", "ROCK");

        verify(mockPlayer, times(1)).incrementScore();
        verify(mockComputer, times(0)).incrementScore();
    }

    @Test
    void test_rock_vs_paper() {
        when(mockPlayer.getChoice()).thenReturn("ROCK");
        when(mockComputer.getComputerChoice()).thenReturn("PAPER");

        game.getRoundWinner("ROCK", "PAPER");

        verify(mockComputer, times(1)).incrementScore();
        verify(mockPlayer, times(0)).incrementScore();
    }

    @Test
    void test_paper_vs_scissors() {
        when(mockPlayer.getChoice()).thenReturn("PAPER");
        when(mockComputer.getComputerChoice()).thenReturn("SCISSORS");

        game.getRoundWinner("PAPER", "SCISSORS");

        verify(mockComputer, times(1)).incrementScore();
        verify(mockPlayer, times(0)).incrementScore();
    }

    @Test
    void test_scissors_vs_rock() {
        when(mockPlayer.getChoice()).thenReturn("SCISSORS");
        when(mockComputer.getComputerChoice()).thenReturn("ROCK");

        game.getRoundWinner("SCISSORS", "ROCK");

        verify(mockComputer, times(1)).incrementScore();
        verify(mockPlayer, times(0)).incrementScore();
    }

    @Test
    void test_rock_vs_rock() {
        when(mockPlayer.getChoice()).thenReturn("ROCK");
        when(mockComputer.getComputerChoice()).thenReturn("ROCK");

        game.getRoundWinner("ROCK", "ROCK");

        verify(mockComputer, times(0)).incrementScore();
        verify(mockPlayer, times(0)).incrementScore();
    }
}
