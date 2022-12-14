package cs145.lab07;

import java.util.Scanner;

public class SocSecProcessor {
	/**
	 * @author MuzikQuincy
	 */

	/**
	 * Main method for user interaction
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name;
		String ssn;
		boolean userContinue = false;

		do {
			if(userContinue) {
				keyboard.nextLine();
			}

			System.out.println("Enter your Name: ");
			name = keyboard.nextLine();

			System.out.println("Enter your SSN: ");
			ssn = keyboard.nextLine();

			try {
				isValid(ssn);

			} catch (SocSecException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Do you want to continue? ");
			String choice = keyboard.next();
			
			if(choice.equalsIgnoreCase("n")) {
				userContinue = false;
			}
			else
			{
				userContinue = true;
			}
			
		} while (userContinue);

	}

	/**
	 * Determines if user input is valid
	 */
	public static boolean isValid(String ssn) throws SocSecException {

		int len = ssn.length();
		int index1 = ssn.indexOf("-");
		int index2 = ssn.lastIndexOf("-");

		if (len != 11) {
			throw new SocSecException(", wrong number of characters");
		}

		if (index1 != 3 || index2 != 6) {
			throw new SocSecException(", dash is in the wrong position");
		}

		for (int i = 0; i <= 10; i++) {
			if (i == 3 || i == 6) {

			} else {
				if (!Character.isDigit(ssn.charAt(i))) {
					throw new SocSecException(", not an integer.");
				}
			}
		}
		return true;
	}

}
