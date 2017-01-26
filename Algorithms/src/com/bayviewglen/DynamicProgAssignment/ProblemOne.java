package com.bayviewglen.DynamicProgAssignment;

public class ProblemOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] zz = { 1, 7, 4, 9, 2, 5 }; //array of numbers
		
		int[] differences = new int[zz.length - 1]; //holds differences 
		int[] solutions = new int[zz.length];     //memoization part, stores num of solutions.

		for (int i = 0; i < differences.length; ++i) { // finds differences
			differences[i] = zz[i] - zz[i + 1];
		}

		for (int i = 0; i < solutions.length; ++i) { // makes everything 1 in solutions
			solutions[i] = 1;
		}

		boolean positive = false; //finds out what the starting integer is, whether its positive or negative
		if (zz[0] > 0) {
			positive = true;
		}else{
			positive =false; 
		}
		int j = 0;

		for (int i = 1; i < differences.length; i++) { //checks and if zig zag, adds to solutions array
			j++;
			if (positive) {
				if (differences[i - 1] < 0 && differences[i] > 0) {
					solutions[j] = solutions[j - 1] + 1; //memoization part, sees how many last solution had and adds one
				}
			}
			if (!positive) {
				if (differences[i - 1] > 0 && differences[i] < 0) {
					solutions[j] = solutions[j - 1] + 1;
				}
			}
			positive = !positive; //switches between positive and negative, since zigzag
		}

		int highestNum = 1;
		for (int i = 0; i < solutions.length; ++i) { // finds prints out the highest num in solutions array 
				if(solutions[i] > highestNum){
					highestNum = solutions[i];
				}
		}
		if(highestNum == 1){
			 System.out.println(1);;
		}else{
			System.out.println(highestNum+1);
		}
	}
}