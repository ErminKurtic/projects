package com.example.RockPaperScissors;

import java.util.Random;

public class Computer {

    private int score;

    enum Move {
        ROCK,
        PAPER,
        SCISSORS
    }

    private String computerChoice;

    public Computer() {
        this.score = 0;
        this.computerChoice = computerMove();
    }

    public String computerMove() {

        Random random = new Random();
        int move = random.nextInt(3) + 1;

        if (move == 1) {
            computerChoice = Move.ROCK.name();
        } else if (move == 2) {
            computerChoice = Move.PAPER.name();
        } else {
            computerChoice = Move.SCISSORS.name();
        }
        return computerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }
}
