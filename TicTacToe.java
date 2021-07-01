/*************************************************************************
 * Purpose : Simulation of tic tac toe game for workshop assignment.
 * UC1-As player would like to start fresh, create a new board.
 * UC2-Ability for player to choose X or O.
 * 
 * @author Pratik Chaudhari
 * @since 27/06/2021
 */

package com.pratik;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		char[] board = createBoard();

		char playerSymbol = playerChooseSymbol(input);
		char computerSymbol = '-';
		if (playerSymbol == 'X' || playerSymbol == 'x' ) {
			computerSymbol = 'O';
		}else { computerSymbol = 'X'; }

	}


	//UC1
	private static char[] createBoard() {
		char[] board = new char[10];
		for(int i =0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}


	//UC2
	public static char playerChooseSymbol(Scanner sc) {

		System.out.println("Please Select your symbol [X] or [O]");

		while(true) {

			char playerChar = sc.next().charAt(0);

			if (Character.compare(playerChar, 'x') == 0 || Character.compare(playerChar, 'X') == 0) {
				System.out.println("Player selected character [X].");
				return 'X';
			}
			else if (Character.compare(playerChar, 'o') == 0 || Character.compare(playerChar, 'O') == 0) {
				System.out.println("Player selected character [O].");
				return 'O';
			}
			else {System.out.println("Enter only enter the alphabets X or O.");}
		}

	}

}
