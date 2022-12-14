package cs145.lab01.guessing;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {

		System.out.println("Welcome to the Hi-Lo guessing game. Try to guess the correct number\r\n"
				+ "between 1 and 100 (inclusive) in as few guesses as possible. We will let you\r\n"
				+ "know if you are correct, or if your guess is too high or too low. If you want to\r\n"
				+ "quit at any time, you can enter -1.");

		int guessCounter = 0;
		int bound = 100;
		boolean validInput = true;
		int pickedNumber = 0;

		// Creates instance of random
		Random random = new Random();

		int numberGen = random.nextInt(bound)+1;

		Scanner keyboard = new Scanner(System.in);

		boolean quit = false;

		do {
		
			try {
				do {
					validInput = false;
					System.out.println("Enter your guess between 1 and 100, or -1 to quit: ");
					pickedNumber = Integer.parseInt(keyboard.next());
					if (pickedNumber == -1 || (pickedNumber >= 1 && pickedNumber <= 100)) {
						validInput = true;
					}
				} while (validInput == false);
			}

			catch (Exception e) {
				System.out.println("Please enter valid number.");
			}
			if (validInput) {

				guessCounter++;

				if (pickedNumber == -1) {
					quit = true;
				}

				else if (pickedNumber == numberGen) {
					numberGen = random.nextInt(bound)+1;
					System.out.println("You are correct.");
					System.out.println("You guessed " + guessCounter + " times");
					guessCounter = 0;
					System.out.println("Do you wish to play again? Y for yes, any other key for no.");
					String answer = keyboard.next();
					if (answer.equalsIgnoreCase("Y")) {
						quit = false;
					} else {
						quit = true;
					}

				}

				else if (pickedNumber > numberGen) {
					System.out.println("You are too high");
				}

				else {
					System.out.println("You are too low");
				}
			}
		} while (!quit);

		System.out.println("Thank you for playing.");
		keyboard.close();
	}

}
