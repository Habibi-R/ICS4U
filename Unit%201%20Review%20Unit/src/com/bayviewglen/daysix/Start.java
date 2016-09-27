package com.bayviewglen.daysix;

import java.util.Scanner;
import java.util.Stack;

public class Start {

	public static Stack<Queen> stackQueen = new Stack<Queen>();
	public static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getN();
		String[][] display = new String[n][n];
		
		
		
		
		
		
		
		
		
		
	}

	public static boolean conflict(Queen currentQueen) {

		Stack<Queen> tempQueens = stackQueen;

		for (int i = 0; i < stackQueen.size(); i++) {
			Queen topQueen = tempQueens.pop();
			int xDif = topQueen.getCol() - currentQueen.getCol();
			int yDif = topQueen.getRow() - currentQueen.getRow();

			if (currentQueen.getCol() == topQueen.getCol() || currentQueen.getRow() == topQueen.getRow()) {
				return false;
			} else if (xDif == yDif) {
				return false;
			}
			return true;
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
	
	public static void setUpDisplay(String[][] display){
		
		for(int i=0; i<display.length; i++){
			for(int j=0; j<display[i].length; j++){
				
			}
		}
		
	}

}
