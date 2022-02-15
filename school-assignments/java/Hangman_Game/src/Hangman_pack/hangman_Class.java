package Hangman_pack;

import java.util.Scanner;

public class hangman_Class {

	private static class SecretWord { // Try to name classes with a Uppercase Letter!

		String secretWord = "mayonnaise";

	}

	public static void hangmanGame(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// - Declares an Object with the secretWord-class!
		SecretWord mySecretWord = new hangman_Class.SecretWord();

		int userChoice; // Ifall det är en String input skriv: String userChoice = ""; behöver ett tomt
						// värde
		int lives = 6;
		boolean gameOn = true;
		
		// - Declaring charArrays outside of while (gameOn) 
		// to be able to return to menu, and let correct letters stay
		
		char[] textArray = mySecretWord.secretWord.toCharArray(); // Transform mySecretWord to an charArray
		char[] myAnswer = new char[textArray.length]; // Declares a new charArray for the answer to match the
														// length of chars in mySecretWord

		for (int i = 0; i < textArray.length; i++) {
			myAnswer[i] = '?';
		}
		

		// A While-Loop for the entire game so that it returns to the proper menu!
		while (gameOn) {

			System.out.println("\nWelcome to Hangman!" + " You will now get four choices: "
					+ "\nPlease press the corresponding number for your choice!" + "\n [1.] Guesses left:"
					+ "\n [2.] Guess a letter:" + "\n [3.] Guess the final word: " + "\n [4.] Quit: ");

			userChoice = scanner.nextInt();

			switch (userChoice) {

			// Menu for lives left!
			case 1:

				System.out.println("\n" + "Lives left: " + lives);
				drawHangman(lives);

				break;

			// Menu for guessing a letter!
			case 2:
				
				System.out.println("Please guess a letter from A - Z: ");


				boolean finished = false;

				while (finished == false) {

					System.out.println("*********************");
					System.out.println("\nType in the number (4) to go back to the menu!");
					String letter = scanner.next();
					
					if (Character.isDigit(letter.charAt(0)) && Integer.parseInt(letter) == 4) {
						finished = true;
						break;
					}

					// - - - - - - - - - - - - 
					boolean found = false;

					for (int i = 0; i < textArray.length; i++) { // - Runs the forloop as long as secretWord.length
						if (letter.charAt(0) == textArray[i]) {  // - If Input(first character) equals to any character in textArray index
							myAnswer[i] = textArray[i];          // - then the answer equals to the textArray index and ends the boolean with true
							found = true;
						}
					}
					if (!found) {  // - Otherwise it reacts to the wrong input and removes 1 life!

						System.out.println("Wrong Letter");
						lives--;
					}
					// - - - - - - - - - - - - 

					boolean done = true;
					for (int i = 0; i < myAnswer.length; i++) {
						if (myAnswer[i] == '?') {
							System.out.print(" _"); // - Types out lines where the letter doesn't match

							done = false;
						} else {
							System.out.print(" " + myAnswer[i]); // - otherwise types out the input letter
						}
					}

					System.out.println("\n" + "Lives left: " + lives);
					drawHangman(lives);

					if (done) {
						System.out.println("You found the word");
						finished = true;
					}

					if (lives <= 0) {
						System.out.println("You are dead!");
						finished = true;
					}

				}
				break;  // Breaks the switch!

			// Menu for guessing the whole word!
			case 3:

				String playerGuess;
				System.out.println("GUESS THE WORD: ");
				playerGuess = scanner.next(); // scanner.nextLine does not work, why?
				if (playerGuess.equals(mySecretWord.secretWord)) {
					System.out.println("WELL DONE!");
				} else {
					System.out.println("Better luck next time... You lost 1 life!");
					lives--;
					break;
				}

				// QUIT
			case 4:

				System.out.println("****** GAME OVER ******");
				gameOn = false;
				break;

			}

		}

		scanner.close();
	}

	// Method that draws out the Hangman in various stages, depending on the amount
	// of lives left!
	public static void drawHangman(int lives) {
		if (lives == 6) {
			System.out.println("|----------");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (lives == 5) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (lives == 4) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|    |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (lives == 3) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (lives == 2) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (lives == 1) {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   /");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else {
			System.out.println("|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   /|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		}
	}

}
