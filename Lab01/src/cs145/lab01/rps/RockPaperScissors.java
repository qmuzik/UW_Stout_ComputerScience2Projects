package cs145.lab01.rps;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	// there are errors in this program
	public static void main(String[] args) {
		int computer;
		int user;
		boolean quit = false;
		// assigning the computer a selection
		Random generator = new Random();
		computer = generator.nextInt(3) + 1;

		// getting the user selection
		Scanner keyboardIn = new Scanner(System.in);
		
		System.out.println("Welcome to Rock-Paper-Scissors");
		System.out.println("Please enter the number of your selection: ");
		System.out.println("1.  Rock");
		System.out.println("2.  Paper");
		System.out.println("3.  Scissors");
		System.out.println("4.  Quit");
		System.out.println();

		do {

			user = keyboardIn.nextInt();

			if (user >= 5) {
				System.out.println("Invalid answer. Please re-type your answer");
				user = keyboardIn.nextInt();
			}
			
			// tell the player what was chosen
			if (user == 1)// player is rock
			{
				System.out.println("Player is rock");
			}

			else if (user == 2)// player is paper
			{
				System.out.println("Player is paper");
			}

			else if (user == 3) // player is scissors
			{
				System.out.println("Player is scissors");
			}

			else if (user == 4) {
				quit = true; 
				break; 
			}

			// tell the player what the computer has chosen
			if (computer == 1)// computer is rock
			{
				System.out.println("Computer is rock");
			}

			else if (computer == 2)// computer is paper
			{
				System.out.println("Computer is paper");
			}

			else if (computer == 3) // computer is scissors
			{
				System.out.println("Computer is scissors");
			}

			// determine winner
			if (user == computer) // tie
			{
				System.out.println("It is a tie");
			}

			else if (user < computer) // player is rock
			{
				if(user == 1 && computer == 3){
					System.out.println("Player wins");
					}
				
				else {
					System.out.println("Computer wins");
				}
			}

			else // computer is scissors
			{
				if(user == 3 && computer == 1) {
					System.out.println("Computer wins");
				}
				else {
					System.out.println("Player wins");
				}
			}

		} while (!quit);
		
		System.out.println("Thanks for playing");
		keyboardIn.close();
	}
}
