package cs145.programmingproject1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeBoardTest {
	TicTacToeBoard board;
	TicTacToeBoard board2;
	TicTacToeBoard board3;
	TicTacToeBoard board4;
	TicTacToeBoard board5;
	TicTacToeBoard board6;

	@BeforeEach
	void setUp() throws Exception {

		board = new TicTacToeBoard();
		board2 = new TicTacToeBoard();
		board3 = new TicTacToeBoard();
		board4 = new TicTacToeBoard();
		board5 = new TicTacToeBoard();
		board6 = new TicTacToeBoard();

	}

	@Test
	void testTicTacToeBoard() {
		assertEquals('X', board.getCurrentPlayer());
		assertEquals(' ', board.getWinner());
		String output = "";

		output = "\t1 \t 2\t 3 \n";

		for (int i = 0; i < 3; i++) {
			output += "   " + (i + 1);
			for (int j = 0; j < 3; j++) {
				output += "|___" + " " + "___|";
			}
			output += "\n";
		}

		assertEquals(output, board.toString());
	}

	@Test
	void testGetCurrentPlayer() {
		assertEquals('X', board.getCurrentPlayer());
		board.takeTurn(0, 0);
		assertEquals('O', board.getCurrentPlayer());
		board.takeTurn(1, 1);
		assertEquals('X', board.getCurrentPlayer());
	}

	@Test
	void testGetWinner() {
		assertEquals(' ', board.getWinner());
		board.takeTurn(0, 0);
		board.takeTurn(1, 0);
		board.takeTurn(0, 1);
		board.takeTurn(1, 2);
		board.takeTurn(0, 2);
		board.checkForWinner();
		assertEquals('X', board.getWinner());
	}

	@Test
	void testTakeTurn() {
		assertEquals('X', board2.getCurrentPlayer());
		board2.takeTurn(0, 1);
		assertEquals('O', board2.getCurrentPlayer());
		board2.takeTurn(0, 1);
		assertEquals('O', board2.getCurrentPlayer());
	}

	@Test
	void testCheckForWinner() {
		assertEquals(' ', board3.getWinner());
		board3.takeTurn(0, 0);
		board3.takeTurn(1, 0);
		board3.takeTurn(0, 1);
		board3.takeTurn(1, 2);
		board3.takeTurn(0, 2);
		board3.checkForWinner();
		assertEquals('X', board3.getWinner());

		assertEquals(' ', board4.getWinner());
		board4.takeTurn(0, 0); // X
		board4.takeTurn(0, 2); // O
		board4.takeTurn(0, 1); // X
		board4.takeTurn(1, 2); // O
		board4.takeTurn(1, 1); // X
		board4.takeTurn(2, 2); //
		board4.checkForWinner();
		assertEquals('O', board4.getWinner());

		assertEquals(' ', board5.getWinner());
		board5.takeTurn(0, 0); // X
		board5.takeTurn(2, 2); // O
		board5.takeTurn(2, 0); // X
		board5.takeTurn(1, 1); // O
		board5.takeTurn(2, 1); // X
		board5.takeTurn(1, 0); // O
		board5.takeTurn(1, 2); // X
		board5.takeTurn(0, 0); // O
		board5.takeTurn(0, 1); // X
		board5.checkForWinner();
		assertEquals(' ',board5.getWinner());
	}

	@Test
	void testToString() {
		assertEquals("\t1 \t 2\t 3 \n   1|___ ___||___ ___||___ ___|\n   2|___ ___||___ ___||___ ___|\n   3|___ ___||___ ___||___ ___|\n",board6.toString());
		board6.takeTurn(0, 0);
		assertEquals("\t1 \t 2\t 3 \n   1|___X___||___ ___||___ ___|\n   2|___ ___||___ ___||___ ___|\n   3|___ ___||___ ___||___ ___|\n",board6.toString());
		board6.takeTurn(1, 0);
		assertEquals("\t1 \t 2\t 3 \n   1|___X___||___ ___||___ ___|\n   2|___O___||___ ___||___ ___|\n   3|___ ___||___ ___||___ ___|\n",board6.toString());
	}

}
