import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static int rowCount = 0;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("text.txt"));

        int counterForPattern3 = 0;
        int counterForPattern4 = 0;
        int counterForPattern5 = 0;
        int counterForPattern6 = 0;
        int counterForPattern7 = 0;

        String pattern1 = "abcdefghijklmnopqrstuvwxyz";
        String pattern2 = "[Oo][Ll][Aa]"; // Checks for first lower-/uppercase letter, then rest of the word
        String pattern3 = "[a]{3,5}";
        String pattern4 = "[^A-Za-z0-9]{2,}";
        String pattern5 = "[\\w_\\.%\\-]+@[\\w_\\.\\-]+\\.[A-Za-z]{2,3}";  //+ en eller fler av parametrarna i brackets  \\w = [A-Za-z0-9]
        String pattern6 = "[\\d]{8}|[\\d]{3}\\s[\\d]{6}|[\\d]{3}\\/[\\d]{6}|[\\d]{3}\\-[\\d]{6}";
        String pattern7 = "([a-zA-Z])\\1{3}";
        String pattern8 = "[a-zA-Z]{3}\\/[0-9]{3}|[a-zA-Z]{3}_[0-9]{3}";
        String pattern9 = "\\([a-zA-Z0-9\\s]+\\)";
        String pattern10 = "(if|for)\\((.)+\\)\\{(.)+\\}";
        // Svårt att veta vad som räknas som if-sats/for-loop då de inte är skrivna i rätt syntax i txt-filen
        // Hittar fler om jag exkluderar } i slutet, men de ser hemska ut

        while (scanner.hasNextLine()) {
            rowCount++;
            String myString = scanner.nextLine();

            findRowCount(myString, pattern1);
            findRowCount(myString, pattern2);
            counterForPattern3 = findCounter(myString, pattern3, counterForPattern3);
            counterForPattern4 = findCounter(myString, pattern4, counterForPattern4);
            counterForPattern5 = findRowAndCounter(myString, pattern5, counterForPattern5);
            counterForPattern6 = findRowAndCounter(myString, pattern6, counterForPattern6);
            counterForPattern7 = findRowAndCounter(myString, pattern7, counterForPattern7);
            findRowCount(myString, pattern8);
            findRowCount(myString, pattern9);
            findRowCount(myString, pattern10);
        }
        System.out.println("- - - - - - - - - - - - - - - - - ");
        System.out.println("\nAmount of places with 3-5 a's: " + counterForPattern3);
        System.out.println("\nPlaces where you can't find: " + pattern4 + ": " + counterForPattern4);
        System.out.println("\nAmount of email-adresses found: " + counterForPattern5);
        System.out.println("\nNumber of phonenumbers found: " + counterForPattern6);
        System.out.println("\nFour of the same letters found: " + counterForPattern7 + " amount of times");

    }

    // -------------------------------------------



    public static void findRowCount(String myString, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){ //searches for string
            if(matcher.group().length() != 0 ) { //print unless length is empty.
                System.out.println(matcher.group() + " is on row: " + rowCount);  //Lägg till count här för att plussa, för att visa antal
            }
        }
    }

    public static int findCounter(String myString, String pattern, int counter){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){ //searches for string
            if(matcher.group().length() != 0 ) { //print unless length is empty.
                counter++;
            }
        }
        return counter;
    }

    public static int findRowAndCounter(String myString, String pattern, int counter){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){ //searches for string
            if(matcher.group().length() != 0 ) { //print unless length is empty.
                System.out.println(matcher.group() + " is on row: " + rowCount);  //Lägg till count här för att plussa, för att visa antal
                counter++;
            }
        }
        return counter;
    }

}

