package cs145.programmingproject1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int row = 0;
		int col = 0;
		boolean validInput = false;
		int turnsTaken = 0;
		String playAgain = "n";
		String tempValue = "";

		Scanner input = new Scanner(System.in);
		TicTacToeBoard board = new TicTacToeBoard();

		System.out.println("Welcome to Tic Tac Toe. To start choose a position and put in a capital X.");

		System.out.println(board.toString());
		do {
			do {
				System.out.println("The current player is " + board.getCurrentPlayer());

				do {
					System.out.println("Please enter a row number between 1 and 3.");
					do {
						try {
						tempValue = input.next();
						row = Integer.parseInt(tempValue);
						validInput = true;
						}
						catch (Exception e) {
							System.out.println("Error. Invalid input, please try again.");
						}
					} while(validInput == false);
					validInput = false;
					System.out.println("Please enter a column number between 1 and 3.");
					do {
						try {
						tempValue = input.next();
						col = Integer.parseInt(tempValue);
						validInput = true;
						}
						catch (Exception e) {
							System.out.println("Error. Invalid input, please try again.");
						}
					} while(validInput == false);
					validInput = false;
					if (row <= 3 && row >= 1 && col <= 3 && col >= 1) {
						row--;
						col--;
						board.takeTurn(row, col);
						validInput = true;
						turnsTaken++;
					}
				} while (validInput == false);
				validInput = false;
				System.out.println(board.toString());
			} while (board.checkForWinner() == false && turnsTaken < 9);

			if (turnsTaken == 9) {
				System.out.println("Cat has won the game.");
			}

			else {
				System.out.println("The winner is " + board.getWinner());
			}
			System.out.println("Would you like to play again? Type y for Yes or anything else for No.");
			playAgain = input.next();
		} while (playAgain != "y");
		input.close();
	}

}
