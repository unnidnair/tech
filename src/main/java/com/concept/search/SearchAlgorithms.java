package com.concept.search;

public class SearchAlgorithms {

	public static void main(String[] args) {
		
		int array[] = {2, 5, 3, 4, 7, 9 };
		int position = binarySearch(array, 0, array.length-1, 2); //Find 3
		System.out.println("Position " + position);
	}

	private static int binarySearch(int[] array, int left, int right, int searchNumber) {
		if ( right >= left) {
			int mid = left + (right - left)/2;
			if (searchNumber == array[mid]) {
				return mid;
			}
			
			if (array[mid] > searchNumber) {
				return binarySearch(array, 0, mid-1, searchNumber);
			} else {
				return binarySearch(array, mid+1, right, searchNumber);
			}
		}
		return -1;
	}

}
