package com.bayviewglen.daysix;

import java.util.Scanner;
import java.util.Stack;

public class Run1 {

	public static Stack<Queen> stackQueen;
	public static int n;
	public static String[][] display;

	public static void main(String[] args) {

		stackQueen = new Stack<Queen>();
		getN();
		display = new String[n][n];
		setUpDisplay();
		placeQueens();
		showDisplay();
	}

	public static boolean conflict(Queen currentQueen) {

		Stack<Queen> tempQueens = new Stack<Queen>();
		tempQueens.addAll(stackQueen);

		for (int i = 0; i < stackQueen.size(); i++) {
			Queen topQueen = tempQueens.pop();

			if (currentQueen.getCol() == topQueen.getCol() || currentQueen.getRow() == topQueen.getRow()
					|| Math.abs((double) (currentQueen.getCol() - topQueen.getCol())
							/ (double) (currentQueen.getRow() - topQueen.getRow())) == 1) {
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

	public static void setUpDisplay() {

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {
				display[i][j] = "* ";
			}
		}
	}

	public static void showDisplay() {

		while (!stackQueen.isEmpty()) {
			Queen temp = stackQueen.pop();
			int x = temp.getRow();
			int y = temp.getCol();
			display[x][y] = "Q ";
		}

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {
				System.out.print(display[i][j] + " ");
			}
			System.out.println("");

		}
	}

	public static void placeQueens() {

		int col = 0;
		int filled = 0;
		boolean solvable = true;
		Queen tempQueen = new Queen();

		while (filled < n && solvable) {

			tempQueen.setRow(filled);
			tempQueen.setCol(col);

			if (col >= n) {

				if (stackQueen.isEmpty() == false) {
					tempQueen = stackQueen.pop();
					col = tempQueen.getCol() + 1;
					filled--;
				} else {
					solvable = false;
					break;
				}
			}

			else if (conflict(tempQueen)) {
				col++;
			} else {
				filled++;
				col = 0;

				Queen tempQueenReal = new Queen();
				tempQueenReal.setRow(tempQueen.getRow());
				tempQueenReal.setCol(tempQueen.getCol());
				stackQueen.push(tempQueenReal);
			}

			if (n == filled) {
				break;
			}
		}

	}

}
