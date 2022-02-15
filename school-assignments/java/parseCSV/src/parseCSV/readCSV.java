package parseCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Scanner;

public class readCSV {

	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<String>> records = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File("sample.csv"));) {

			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ---------------------------------

		// - Function to HashMap the list of information, and then compare to the original to find which names use the same timestamp
		// ...and then print out all the names who fit in the right timestamp
		
		// ----- Key, Value ------//
		HashMap<String, String> hash = new HashMap<String, String>();

		int i = 0;

		for (List<String> b : records) {

			if (i != 0) { // - Skips the first title-row
				hash.put(b.get(0), "");

			} else {
				i++;
			}

		}

		System.out.println("List of people using same timestamp: \n");

		for (String timestamp : hash.keySet()) { // - keySet looks at the keys, not the value in Hash

			String names = timestamp + " ";

			for (List<String> b : records) {

				if (b.get(0).equals(timestamp)) {

					names += b.get(1) + " " + b.get(2) + " ";
				}

			}
			System.out.println(names);
		}

		// -------------------------------
		// - Function to find all the ones using android and then adding ++ to a counter to get number amount
		
		int counter = 0;

		for (List<String> row : records) {

			if (row.get(6).toLowerCase().contains("android")) {

				counter++;
			}

		}

		System.out.println("\n - Amount of people using Android: " + counter + "\n");

		// ------------------------------
        // - Function to look in the 1 and 2 index to find all names that have an "A" in them
		System.out.println(" - List of people with an 'A' in their name: ");
		
		i = 0;

		for (List<String> b : records) {

			if (i != 0) {  // - Skips the first title-row

				if (b.get(1).toLowerCase().contains("a") && b.get(2).toLowerCase().contains("a")) {

					System.out.println(b.get(1) + "\n" + b.get(2));
				}

			} else {
				i++;
			}

		}

	}

	// --------------------------------------------------------------------

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();

		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}

		}

		return values;
	}

}
