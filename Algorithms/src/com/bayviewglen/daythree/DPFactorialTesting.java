package com.bayviewglen.daythree;

public class DPFactorialTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}
public static int factorial(int num){
		
		int[] stored  = new int[num];
		
		for(int i=0; i<stored.length; i++){
			if(stored[i] == num){
				return num;
			}
		}
		
		if(num==0){
		return 1;	
		}else{
			
			return num* factorial(num-1);
		}
		
	}
}
