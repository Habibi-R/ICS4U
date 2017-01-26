package com.bayviewglen.DynamicProgAssignment;

public class ProblemTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = -1;
		
		int[] donations = new int[] {5,3,2,5,4};
		
		if(donations.length == 2){
			answer = Math.max(donations[0],donations[1]);
		}
		
		
		int[] a = new int[donations.length];
		int[] b = new int[donations.length];
		
		a[0] = donations[0];
		a[1] =donations[1];
		b[0] = 1;
		
		for(int i=2; i<donations.length; i++){
			a[i] = 0;
			b[i] = 0;
		}
		
	}

}
