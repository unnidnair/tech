package com.concept.bit;

import java.math.BigInteger;

public class AllSubsequence {
	
	//static int arr[] = new int[]{1, 2, 3, 4};
	
	static char arr[] = "abc".toCharArray();

	public static void main(String[] args) {
		printSubsequences(arr.length);
	}
	
//	Value of Counter            Subset
//    000                    -> Empty set
//    001                    -> a
//    010                    -> b
//    011                    -> ab
//    100                    -> c
//    101                    -> ac
//    110                    -> bc
//    111                    -> abc

	private static void printSubsequences(int length) {
		
		int total = 0;
		
		if (null!=arr && arr.length > 0) {
			
			int powerSet = (int) Math.pow(2, length); //2^4 = 16
			
			for (int counter=1; counter< powerSet; counter++) { // counter = 1 to 15
				
				for (int j=0; j<length; j++) { //from 0 to 4
					
					if (BigInteger.valueOf(counter).testBit(j)) {
						System.out.print( arr[j] + " ");
						total++;
					}
					
				}
				System.out.println("");
				
			}
			System.out.println(total + " permutations powerset " + powerSet);
		}
		
		
		
		
	}

}
