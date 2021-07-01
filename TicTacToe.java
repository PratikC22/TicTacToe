/*************************************************************************
 * Purpose : Simulation of tic tac toe game for workshop assignment.
 * UC1-As player would like to start fresh, create a new board.
 * UC2-Ability for player to choose X or O.
 * UC3-Write a method show board to display board.
 * UC4-Ability for player to move on desired place on board.
 * UC5-Ability to check for free space before making desired move.
 * UC6-Toss to decide who plays first.
 * UC7-Change the turn.
 * UC8-First thing I do is check if I can win.
 * 
 * @author Pratik Chaudhari
 * @since 27/06/2021
 **************************************************************************/

package com.pratik;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		// Various Variables used in main()
		Scanner input = new Scanner(System.in);
		char[] board = createBoard();
		char playerSymbol = playerChooseSymbol(input), opponentSymbol = (playerSymbol == 'X') ? 'O' : 'X';
		int gameTypeChoice = getGameTypeChoice(input);
		char isPlayerTurnNow = toss(input);

		do {
			if (isPlayerTurnNow == 'P') {
				playerMove(board, input, playerSymbol);
				isPlayerTurnNow = 'O';
			} else if (isPlayerTurnNow == 'O') {
				if (gameTypeChoice == 2) {
					playerMove(board, input, opponentSymbol);
					isPlayerTurnNow = 'P';
				} else if (gameTypeChoice == 1) {
					computerPlays(board, opponentSymbol, playerSymbol);
					isPlayerTurnNow = 'P';
				}
			} else {
				isPlayerTurnNow = toss(input);
			}

			switch (whoWon(board)) {
			case 'T':
				System.out.println("Board has no empty spaces , Game ended in a tie.");
				break;
			case 'X':
				showBoard(board);
				System.out.println("Player [X] won the game.");
				break;
			case 'O':
				showBoard(board);
				System.out.println("Player [O] won the game.");
				break;
			}

		} while (whoWon(board) == 'E');

	}

	// UC1
	private static char[] createBoard() {
		char[] board = new char[10];
		Arrays.fill(board, '-');
		return board;
	}

	// UC2
	public static char playerChooseSymbol(Scanner sc) {

		System.out.println("Please Select your symbol [X] or [O]");

		while (true) {

			char playerChar = sc.next().charAt(0);

			if (playerChar == 'x' || playerChar == 'X') {
				System.out.println("You are Player [X] now.");
				return 'X';
			} else if (playerChar == 'o' || playerChar == 'O') {
				System.out.println("You are Player [O] now");
				return 'O';
			} else {
				System.out.println("Enter only enter the alphabets X or O.");
			}
		}
	}

	// UC3
	public static void showBoard(char[] board1) {

		System.out.println("-------         Position Map-");
		for (int i = 1; i < 10; i++) {
			System.out.printf("|%s", board1[i]);
			if (i % 3 == 0) {
				System.out.printf("|         [%d][%d][%d]\n", i - 2, i - 1, i);
			}
		}
		System.out.println("-------");
	}

	// UC4
	public static void playerMove(char[] board2, Scanner Input, char playerChar) {

		System.out.printf("Player [%s] please make your move.\n", playerChar);
		int slotStatus = isIndexEmpty(board2, Input);

		if (slotStatus != 0) {
			board2[slotStatus] = playerChar;
		} else {
			System.out.println("\n\n !!! The position you selected is already filled !!! \n"
					+ "!!! Please select empty position !!!\n\n");
			playerMove(board2, Input, playerChar);
		}
	}

	// UC4 and UC5
	public static int isIndexEmpty(char[] board1, Scanner input) {

		int index;
		do {
			showBoard(board1);
			System.out.println("Please enter a position between 1 to 9.");
			index = input.nextInt();
		} while (!(index > 0 && index < 10));

		if (board1[index] == 'X' || board1[index] == 'O') {
			return 0;
		}
		return index;
	}

	// UC6
	public static char toss(Scanner sc) {

		System.out.println("Type [H] or [T] for coin toss.");
		char playerTossCall = sc.next().toUpperCase().charAt(0);

		if (playerTossCall != 'H' && playerTossCall != 'T') {
			System.out.println("Please only call [H] or [T]");
			return 'Z';
		} else {
			System.out.println("A coin was tossed");
		}

		char playerWonOrNot = ((((int) (Math.random() * 10)) % 2) == 0) ? 'P' : 'O';
		if (playerWonOrNot == 'P')
			System.out.printf("Coin turned up [%s]. You Won. You will play first.\n", playerTossCall);
		else
			System.out.printf("Coin turned up [%s]. You lost. Your opponent will play first.\n",
					(playerTossCall == 'H') ? 'T' : 'H');

		return playerWonOrNot;
	}

	// UC7
	public static char whoWon(char[] board) {

		for (int caseNum = 0; caseNum < 8; caseNum++) {
			switch (caseNum) {
			case 0:
				if (board[1] == board[2] && board[2] == board[3] && board[1] != '-') {
					return board[1];
				}
				break;
			case 1:
				if (board[4] == board[5] && board[5] == board[6] && board[4] != '-') {
					return board[4];
				}
				break;
			case 2:
				if (board[7] == board[8] && board[8] == board[9] && board[7] != '-') {
					return board[7];
				}
				break;
			case 3:
				if (board[1] == board[4] && board[4] == board[7] && board[1] != '-') {
					return board[1];
				}
				break;
			case 4:
				if (board[2] == board[5] && board[5] == board[8] && board[2] != '-') {
					return board[2];
				}
				break;
			case 5:
				if (board[3] == board[6] && board[6] == board[9] && board[3] != '-') {
					return board[3];
				}
				break;
			case 6:
				if (board[1] == board[5] && board[5] == board[9] && board[1] != '-') {
					return board[1];
				}
				break;
			case 7:
				if (board[3] == board[5] && board[5] == board[7] && board[3] != '-') {
					return board[3];
				}
				break;
			}
		}

		String doesBoardHaveEmptySpace = "" + board[1] + board[2] + board[3] + board[4] + board[5] + board[6] + board[7]
				+ board[8] + board[9];
		if (doesBoardHaveEmptySpace.contains("-")) {
			return 'E';
		}

		return 'T';
	}

	// UC8
	public static boolean threeCharCompare(char first, char second, char third) {
		return first == second && second == third;
	}

	// UC8
	public static int getGameTypeChoice(Scanner sc) {

		int gameTypeChoiceInput;

		do {
			System.out.println("Please input choice\n" + "[1] Play against Computer\n" + "[2] 2 Player game\n");
			gameTypeChoiceInput = sc.nextInt();
		} while (gameTypeChoiceInput != 1 && gameTypeChoiceInput != 2);

		return gameTypeChoiceInput;

	}

	// UC8
	public static void computerPlays(char[] board, char computerCharacter, char playerCharacter) {

		int indexChosen = computerChoosesIndex(board, computerCharacter, playerCharacter);
		board[indexChosen] = computerCharacter;
		System.out.printf("Computer Played at position [%d]\n", indexChosen);
	}

	// UC8
	public static int computerChoosesIndex(char[] board, char computerCharacter, char playerCharacter) {

		// playToWin Logic
		for (int caseNum = 1; caseNum < 10; caseNum++) {
			switch (caseNum) {
			case 9:
				if (board[9] != playerCharacter && (threeCharCompare(board[3], board[6], computerCharacter)
						|| threeCharCompare(board[7], board[8], computerCharacter)
						|| threeCharCompare(board[1], board[5], computerCharacter))) {
					return 9;
				}
				break;
			case 8:
				if (board[8] != playerCharacter && (threeCharCompare(board[7], board[9], computerCharacter)
						|| threeCharCompare(board[2], board[5], computerCharacter))) {
					return 8;
				}
				break;
			case 7:
				if (board[7] != playerCharacter && (threeCharCompare(board[1], board[4], computerCharacter)
						|| threeCharCompare(board[9], board[8], computerCharacter)
						|| threeCharCompare(board[3], board[5], computerCharacter))) {
					return 7;
				}
				break;
			case 6:
				if (board[6] != playerCharacter && (threeCharCompare(board[3], board[9], computerCharacter)
						|| threeCharCompare(board[4], board[5], computerCharacter))) {
					return 6;
				}
				break;
			case 5:
				if (board[5] != playerCharacter && (threeCharCompare(board[2], board[8], computerCharacter)
						|| threeCharCompare(board[4], board[6], computerCharacter)
						|| threeCharCompare(board[1], board[9], computerCharacter)
						|| threeCharCompare(board[3], board[7], computerCharacter))) {
					return 5;
				}
				break;
			case 4:
				if (board[4] != playerCharacter && (threeCharCompare(board[5], board[6], computerCharacter)
						|| threeCharCompare(board[1], board[7], computerCharacter))) {
					return 4;
				}
				break;
			case 3:
				if (board[3] != playerCharacter && (threeCharCompare(board[9], board[6], computerCharacter)
						|| threeCharCompare(board[7], board[5], computerCharacter)
						|| threeCharCompare(board[1], board[2], computerCharacter))) {
					return 3;
				}
				break;
			case 2:
				if (board[2] != playerCharacter && (threeCharCompare(board[5], board[8], computerCharacter)
						|| threeCharCompare(board[1], board[3], computerCharacter))) {
					return 2;
				}
				break;
			case 1:
				if (board[1] != playerCharacter && (threeCharCompare(board[3], board[2], computerCharacter)
						|| threeCharCompare(board[7], board[4], computerCharacter)
						|| threeCharCompare(board[9], board[5], computerCharacter))) {
					return 1;
				}
				break;
			}
		}
		for (int i = 1; i < 10; i++) {
			if (board[i] == '-') {
				return i;
			}

		}
		return 11;
	}

}
