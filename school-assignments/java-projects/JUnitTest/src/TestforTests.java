import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.EnableJUnit4MigrationSupport;
import java.util.Scanner;

@EnableJUnit4MigrationSupport
@DisplayName("Password and Palindrome Test!!!")
class TestforTests {

	@Test
	void checkPasswordMatch() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number between 1 - 20: ");
		int password1 = passwordTest.passwordMatch(scanner);

		System.out.println("\nRe-enter your chosen number: ");
		int password2 = passwordTest.passwordMatch(scanner);

		assertTrue(password1 == password2);

	}
	
	@Test
	void checkPalindromeMatch() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a string/number to check if it is a palindrome");
		String input = PalindromeTest.palindromeCheck(scanner);
		
		String reverse = "";
		
		int length = input.length();   
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + input.charAt(i);  
	      
	      assertEquals(input,reverse);
	   }  
		
		
	}

	// ---------------------------------------------------

	// assertEquals

//	@Test
//	void addition() {
//
//		System.out.println(" adding test");
//		Calculator calculator = new Calculator();
//		assertEquals(2, calculator.add(1, 1));
//	}
//
//	@Test
//	void additionButFails() {
//
//		System.out.println(" adding failing test");
//		Calculator calculator = new Calculator();
//		assertEquals(2, calculator.add(2, 1));
//	}


