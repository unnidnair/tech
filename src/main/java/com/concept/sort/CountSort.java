package com.concept.sort;

public class CountSort {

	public static void main(String[] args) {
		CountSort sort = new CountSort();
		int[] input = {1, 4, 1, 2, 7, 5, 2};
		int[] output = sort.sortArray(input, 7);
		for (int i: output) {
			System.out.print(i + " ");
		}
	}

	private int[] sortArray(int[] input, int max) {
		
		int[] output = new int[input.length+1];
		int[] count = new int[max+1];
		
		for (int i=0; i <max+1; i++) {
			count[i] = 0;
		}
		
		for (int i=0; i <input.length; i++) {
			count[input[i]] = ++count[input[i]];
		}
		
		for (int i=1; i<count.length; i++) {
			count[i] = count[i-1]+count[i];
		}
		
		for (int i: count) {
			System.out.print(i + " ");
		}
		
		for (int i=0; i< input.length; i++) {
			int val = count[input[i]];
			output[val] = input[i];
			count[input[i]] = --val;
		}
		
		return output;
	}

}
