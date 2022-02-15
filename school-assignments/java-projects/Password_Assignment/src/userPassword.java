import java.util.Scanner;
public class userPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Welcome user! " 
		        + "\nYou will now create a password for this account! "
				+ "\nThe password can contain both letters and numbers. "
				+ "\n\nPlease enter a password you wish to use:");
		
		String password1 = reader.nextLine();  // User inputs a desired password
		
		
		
		for (int loginAttempts = 1; loginAttempts < 4; loginAttempts++) {  // Runs a for-loop to check amount of login attempts in case the user fails to
			                                                               // retype the same password below
			
			System.out.println("\nPlease re-enter your chosen password:");
			String password2 = reader.nextLine();  // Asks the user to re-input the chosen password
			
			if (password1.equals(password2)) {  // If the two passwords match, the program finishes and then BREAKS out of the for-loop
				
				System.out.println("\nYou have confirmed your password successfully! " 
	                             + "\nPlease use it next time you try to login.");
				break;
			}
			else {   // If the two passwords don't match, then...
				
				if (loginAttempts < 3) {  // ...it checks if the user inputs it wrong up to two times...
					
				System.out.println("\nWe're sorry. Your password don't match. "  
		                  + "\nPlease try again (You have used up " + loginAttempts + "/3 attempts). ");  // ...and asks them to retry
				}
				else { // If they fail a third time, this message is shown
					
					System.out.println("\nSorry, you have used up all your attempts. " +
			                "\nThe program will now shut down. Better luck next time! ");
				}
			}
			
		}
		
		reader.close();

	}

}
