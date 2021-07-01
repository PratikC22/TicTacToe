/*************************************************************************
 * Purpose : Simulation of tic tac toe game for workshop assignment.
 * UC1-As player would like to start fresh, create a new board.
 * 
 * @author Pratik Chaudhari
 * @since 27/06/2021
 */

package com.pratik;

public class TicTacToe {
	public static void main(String[] args) {

		// UC1
		char[] board = createBoard();
	}

	private static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

}
