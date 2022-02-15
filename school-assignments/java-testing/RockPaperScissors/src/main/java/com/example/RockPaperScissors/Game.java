package com.example.RockPaperScissors;

import java.awt.*;

public class Game {

    Player player;
    Computer computer;

    public Game(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void startGame() {

        while (player.getScore() != 3 && computer.getScore() != 3) {

            drawMenu();
            getRoundWinner(player.playerInput(), computer.computerMove());
        }
    }

    public void getRoundWinner(String playerChoice, String computerChoice) {

        if (playerChoice.equals("PAPER") || playerChoice.equals("ROCK") || playerChoice.equals("SCISSORS")) {

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a draw!");
                System.out.println(computerChoice);
            } else if (playerChoice.equals("ROCK") && computerChoice.equals("PAPER")
                    || playerChoice.equals("PAPER") && computerChoice.equals("SCISSORS")
                    || playerChoice.equals("SCISSORS") && computerChoice.equals("ROCK")) {

                computer.incrementScore();
                System.out.println("Computer chose: " + computerChoice);
                System.out.println("Computer gets a point!");
                if (computer.getScore() == 3) {
                    System.out.println("Computer wins!");
                }
            } else {
                player.incrementScore();
                System.out.println("Computer chose: " + computerChoice);
                System.out.println("Player gets a point");
                if (player.getScore() == 3) {
                    System.out.println("Player wins!");
                }
            }
        } else {
            System.out.println("\nInvalid choice! Please enter \"ROCK\", \"PAPER\" or \"SCISSORS\" with capital letters!");
        }
    }


    public void drawMenu() {
        System.out.println("\nPlease input your move you wish to make!");
        System.out.println("CURRENT SCORE - Player: " + player.getScore() + " Computer: " + computer.getScore());
    }
}
