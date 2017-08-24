package com.concept.algorithms;

public class RotateArray {

	public static void main(String[] args) {
		RotateArray r1 = new RotateArray();
		int[] arr = {1,2,3,4,5,6,7} ;
		for (int j:arr) {
			System.out.print(j + " ");
		}
		r1.rotate(arr, 3);
		System.out.println("");
		for (int j:arr) {
			System.out.print(j + " ");
		}
	}

	private void rotate(int[] arr, int order) {
		
		if (null==arr || arr.length ==0 | order < 0) {
			System.out.println("Illegal params");
		}
		
		if (order > arr.length) {
			order = order % arr.length;
		}
		
		int a = arr.length - order; 
		
		rotate(arr, 0, a-1);
		rotate(arr, a, arr.length-1);
		rotate(arr, 0, arr.length-1);
		
	}

	private void rotate(int[] arr, int left, int right) {
		
		if(arr == null || arr.length == 1) 
			return;
		
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++; right --;
		}
		
	}
	
	

}
