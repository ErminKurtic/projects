import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	
	
    // - Main Starting Menu for choosing whether you want to play Player vs Player, or one player against the computer
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

		int userChoice;

		System.out.println("Welcome to the ultimate game of Rock, Paper and Scissors!\n"
				+ "\nYou will now get to choose if you want to play against another player, or against the computer"
				+ "\nPlease select one of the following by typing [1] or [2]: \n" + "\n[1]. Player vs Player"
				+ "\n[2]. Player vs Computer");

		userChoice = scanner.nextInt();
		

		// - Depending on your choice, it either runs PvP-method or the PvAI method!
		if (userChoice == 1) {

			gamePlayerVsPlayer(args);
		} 
		else if (userChoice == 2) {

			gamePlayerVSComputer(args);
		}
		else {
			
			System.out.println("\nWell, seems you can't follow simple instructions. Better luck next time!"
					+ "\nShutting game down....");
		}
		scanner.close();
	}


	// - The main game for Player vs Computer, using necessary methods and determining a winner
	public static void gamePlayerVSComputer(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String playerOneChoice;
		String computerChoice;
		Random random = new Random();

		showMenu();
		
        // - Assigning a method to a variable, so the information can be used in the winnercheck below
		playerOneChoice = playerOneChoice(scanner);
		System.out.println("\nYou chose " + playerOneChoice + "\n");

		computerChoice = computerChoice(random);
		
		// - - - - - -  Runs an IF-Statement to check who the winner is! - - - - -

		if (playerOneChoice.equals(computerChoice)) {

			System.out.println("\nIT'S A TIE!!!");

		} else if (playerOneChoice == "Rock" && computerChoice == "Paper"
				|| playerOneChoice == "Paper" && computerChoice == "Scissors"
				|| playerOneChoice == "Scissors" && computerChoice == "Rock") {

			System.out.println("\nComputer WINS!!!   Thanks for playing!");
		} else {

			System.out.println("\nYOU WIN!!!   Thanks for playing!");
		}

	}

	// - The main game for Player vs Player, calling on the necessary methods and checking for a winner
	public static void gamePlayerVsPlayer(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		String playerOneName, playerTwoName;
		String playerOneChoice, playerTwoChoice;

		System.out.println("You decided to play Player vs Player!");

		playerOneName = playerOneName(scanner); // Ties the method-result into "playerOneName"-variable

		playerTwoName = playerTwoName(scanner); // Ties the method-result into "playerTwoName"-variable

		showMenu();

		playerOneChoice = playerOneChoice(scanner); // - Same as the above, declaring a variable to the called upon method
		System.out.println(playerOneName + " chose " + playerOneChoice + "\n");

		showMenu();

		playerTwoChoice = playerTwoChoice(scanner);
		System.out.println(playerTwoName + " chose " + playerTwoChoice + "\n");

		// - - - - - -  Runs an IF-Statement to check who the winner is! - - - - -

		if (playerOneChoice.equals(playerTwoChoice)) {

			System.out.println("\nIT'S A TIE!!!");
		} else if (playerOneChoice == "Rock" && playerTwoChoice == "Paper"
				|| playerOneChoice == "Paper" && playerTwoChoice == "Scissors"
				|| playerOneChoice == "Scissors" && playerTwoChoice == "Rock") {

			System.out.println(playerTwoName + " WINS!!!  Thanks for playing!");
		} else {

			System.out.println(playerOneName + " WINS!!!  Thanks for playing!");
		}

	}

	// - A randomizer for the computer choice
	public static String computerChoice(Random random) {

		int numberChoice;
		numberChoice = random.nextInt(3) + 1; // It randomizes between 0 and 2, that's why we have to put +1 afterwards
		String wordChoice = "";

		if (numberChoice == 1) {
			wordChoice = "Rock";
		} else if (numberChoice == 2) {
			wordChoice = "Paper";
		} else if (numberChoice == 3) {
			wordChoice = "Scissors";
		}

		System.out.println("\nThe computer chose " + wordChoice);

		return wordChoice;

	}

	// - Reads the player number selection and writes out the chosen weapon!
	public static String playerOneChoice(Scanner scanner) {

		System.out.println("\nPlayer one, please make your choice: ");

		int numberChoice;
		numberChoice = scanner.nextInt();
		String wordChoice = ""; // <- - - Konstig lösning, men går inte att lämna tomt eller låta stå null, då returneras inget värde :(

		if (numberChoice == 1) {
			wordChoice = "Rock";
		} else if (numberChoice == 2) {
			wordChoice = "Paper";
		} else if (numberChoice == 3) {
			wordChoice = "Scissors";
		}

		return wordChoice;
	}

	// - Same as the above!
	public static String playerTwoChoice(Scanner scanner) {

		System.out.println("\nPlayer Two, please make your choice: ");

		int numberChoice;
		numberChoice = scanner.nextInt();
		String wordChoice = "";

		if (numberChoice == 1) {
			wordChoice = "Rock";
		} else if (numberChoice == 2) {
			wordChoice = "Paper";
		} else if (numberChoice == 3) {
			wordChoice = "Scissors";
		}

		return wordChoice;
	}

	// - Player One gets to chose a name for themselves
	public static String playerOneName(Scanner scanner) {

		String playerOneName;

		System.out.println("\nPlayer One, Please enter your name: ");
		playerOneName = scanner.nextLine();

		return playerOneName;
	}

	// - Player Two gets to chose a name for themselves
	public static String playerTwoName(Scanner scanner) {

		String playerTwoName;

		System.out.println("\nPlayer Two, please enter your name: ");
		playerTwoName = scanner.nextLine();

		return playerTwoName;
	}

	// - Shows the main menu for selecting Rock, Paper or Scissors
	public static void showMenu() {

		System.out.println("\nChoose one of the following by pressing corresponding number:" + "\n[1]. Rock"
				+ "\n[2]. Paper" + "\n[3]. Scissors");
	}

}
