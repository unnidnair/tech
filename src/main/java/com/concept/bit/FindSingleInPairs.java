package com.concept.bit;

public class FindSingleInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,2,5,7,3,7};
		System.out.println(findSingle(arr));
	}

	private static int findSingle(int[] arr) {
		int result = arr[0];
		for (int i=0; i< arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}
	


}
