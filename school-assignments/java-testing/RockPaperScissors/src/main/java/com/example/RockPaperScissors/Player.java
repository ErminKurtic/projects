package com.example.RockPaperScissors;

import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    private String choice;
    private int score;

    public Player() {
        this.choice = "";
        this.score = 0;
    }

    public String getChoice() {
        return choice;
    }

    public String setChoice(String choice) {
        this.choice = choice.toUpperCase();

        return choice;
    }

    public String playerInput() {
        return setChoice(scanner.nextLine());
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }
}
