package com.bayviewglen.daysix;

import java.util.Scanner;
import java.util.Stack;

public class Start {

	public static Stack<Queen> stackQueen = new Stack<Queen>();
	public static int n;
	public static int[][] display;

	public static void main(String[] args) {

		getN();
		display = new int[n][n];
		//display = setUpDisplay(display);
		//placeQueens();
		//showDisplay(display);

		int filled = 0;
		int column = 0;
		boolean solvable = true;

		while (filled < n && solvable) {
			Queen tempQueen = new Queen(filled, column);

			if (column >= n) {
				if (!stackQueen.isEmpty()) {
					tempQueen = stackQueen.pop();
					column = tempQueen.getCol() + 1;
					filled--;

				} else {
					System.out.println("not solvable");
					solvable = false;
				}
			} else if (conflict(tempQueen)) {
				column++;
			} else {
				filled++;
				column = 0;
				stackQueen.push(new Queen(tempQueen.getRow(), tempQueen.getCol()));
			}
			if (filled == n) {
				showDisplay();
			}
		}

	}

	public static boolean conflict(Queen currentQueen) {

		Stack<Queen> tempQueens = stackQueen;

		for (int i = 0; i < stackQueen.size(); i++) {
			Queen topQueen = tempQueens.pop();

			if (currentQueen.getCol() == topQueen.getCol() || currentQueen.getRow() == topQueen.getRow()
					|| Math.abs((double) (currentQueen.getCol() - topQueen.getCol())
							/ (double) (currentQueen.getRow() - topQueen.getRow())) == 1){
				return true;
			}
		}
		return false;
	}

	public static void getN() {
		boolean valid = false;
		while (!valid) {
			System.out.println("What is n?");
			Scanner input = new Scanner(System.in);
			String nTemp = input.nextLine();
			n = -1;
			try {
				n = Integer.parseInt(nTemp);
				valid = true;
			} catch (Exception ex) {
				System.out.println("Please enter a valid n...");
			}
		}
	}

	public static String[][] setUpDisplay(String[][] display) {

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {
				display[i][j] = "*";
			}
		}
		return display;
	}

	public static void showDisplay() {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				display[i][j] = 0;
			}
		}

		for (int i = 0; i < stackQueen.size(); i++) {
			Queen temp = stackQueen.pop();
			int x = temp.getRow();
			int y = temp.getCol();

			display[x][y] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (display[i][j] == 1) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println("");
		}
	}

	public static void placeQueens() {
		int startCol = 0;

		for (int i = 0; i < n; i++) {

			for (int col = startCol; col < display[i].length; col++) {
				Queen tryQueen = new Queen();
				tryQueen.setCol(col);
				tryQueen.setRow(i);

				if (conflict(tryQueen) == false) {
					//display[i][col] = "Q";
					stackQueen.push(tryQueen);

				}

			}

		}
	}

}
