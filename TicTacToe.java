/*************************************************************************
 * Purpose : Simulation of tic tac toe game for workshop assignment.
 * UC1-As player would like to start fresh, create a new board.
 * UC2-Ability for player to choose X or O.
 * UC3-Write a method show board to display board.
 * 
 * @author Pratik Chaudhari
 * @since 27/06/2021
 **************************************************************************/

package com.pratik;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		// Various Variables used in main()
		Scanner input = new Scanner(System.in);
		char[] board = createBoard();
		boolean endGameFlag = false;
		char choiceYesOrNo = '-';

		char playerSymbol = playerChooseSymbol(input);
		char computerSymbol = '-';
		if (playerSymbol == 'X' || playerSymbol == 'x') {
			computerSymbol = 'O';
		} else {
			computerSymbol = 'X';
		}

		do {

			showBoard(board);

			System.out.println("Do you want to end the Game? Enter [Y] / [N].");
			choiceYesOrNo = input.next().toUpperCase().charAt(0);
			endGameFlag = (choiceYesOrNo == 'Y') ? false : true;

		} while (endGameFlag);

	}

	// UC1
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

	// UC2
	public static char playerChooseSymbol(Scanner sc) {

		System.out.println("Please Select your symbol [X] or [O]");

		while (true) {

			char playerChar = sc.next().charAt(0);

			if (Character.compare(playerChar, 'x') == 0 || Character.compare(playerChar, 'X') == 0) {
				System.out.println("Player selected character [X].");
				return 'X';
			} else if (Character.compare(playerChar, 'o') == 0 || Character.compare(playerChar, 'O') == 0) {
				System.out.println("Player selected character [O].");
				return 'O';
			} else {
				System.out.println("Enter only enter the alphabets X or O.");
			}
		}
	}

	// UC3
	public static void showBoard(char[] board1) {

		System.out.println("-------");
		for (int i = 1; i < 10; i++) {
			System.out.printf("|" + board1[i]);
			if (i % 3 == 0) {
				System.out.printf("|\n");
			}
		}
		System.out.println("-------");
	}

}
