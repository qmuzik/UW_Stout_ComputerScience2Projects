package cs145.programmingproject1;

public class TicTacToeBoard {

	private char currentPlayer;
	private char[][] board;
	private char winner;

	/**
	 * Constructor for the TicTacToeBoard
	 **/

	public TicTacToeBoard() {
		board = new char[3][3];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}

		this.currentPlayer = 'X';
		this.winner = ' ';
	}

	/**
	 * Getter for the current player
	 * 
	 * @return currentPlayer The player currently taking a turn
	 */

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Getter for the winner
	 * 
	 * @return winner Player who won the game
	 */

	public char getWinner() {
		return winner;
	}

	/**
	 * Simulates the users taking a turn
	 * 
	 * @param row X location on the 2d array
	 * @param col Y location on the 2d array
	 * 
	 * @return true The player has taken a turn
	 * @return false The player has not taken a turn
	 * 
	 */

	public boolean takeTurn(int row, int col) {

		if (board[row][col] == ' ') {
			board[row][col] = currentPlayer;
			if (currentPlayer == 'X') {
				currentPlayer = 'O';
			} else {
				currentPlayer = 'X';
			}
			return true;
		}

		else {
			System.out.println("This space has already been taken. Please choose a different space.");
			return false;
		}

	}

	/**
	 * Determines who won the game
	 * 
	 * 
	 * @return true if any of the conditions have been met
	 * @return false if no conditions have been met
	 * 
	 */

	public boolean checkForWinner() {

		char winnerCheck;

		if (currentPlayer == 'X') {
			winnerCheck = 'O';
		} else {
			winnerCheck = 'X';
		}
		winner = winnerCheck;

		if (board[0][0] == winnerCheck) {
			if (board[0][1] == winnerCheck && board[0][2] == winnerCheck) {
				return true;
			}
			if (board[1][0] == winnerCheck && board[2][0] == winnerCheck) {
				return true;
			}
		}

		if (board[1][1] == winnerCheck) {
			if (board[1][0] == winnerCheck && board[1][2] == winnerCheck) {
				return true;
			}
			if (board[0][1] == winnerCheck && board[2][1] == winnerCheck) {
				return true;
			}
			if (board[2][0] == winnerCheck && board[0][2] == winnerCheck) {
				return true;
			}
			if (board[0][0] == winnerCheck && board[2][2] == winnerCheck) {
				return true;
			}

		}

		if (board[2][2] == winnerCheck) {
			if (board[0][2] == winnerCheck && board[1][2] == winnerCheck) {
				return true;
			}
			if (board[2][0] == winnerCheck && board[2][1] == winnerCheck) {
				return true;
			}
		}
		winner = ' ';
		return false;
	}

	/**
	 * Displays the game board
	 *
	 * 
	 * @return output The tic-tac toe board with player progression
	 * 
	 */

	public String toString() {

		String output = "";

		output = "\t1 \t 2\t 3 \n";

		for (int i = 0; i < board.length; i++) {
			output += "   " + (i + 1);
			for (int j = 0; j < board[i].length; j++) {
				output += "|___" + board[i][j] + "___|";
			}
			output += "\n";
		}
		return output;
	}
}
