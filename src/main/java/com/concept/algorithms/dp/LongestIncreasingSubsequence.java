package com.concept.algorithms.dp;

//Video Explanation - https://www.youtube.com/watch?v=CE2b_-XfVDk

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence sub = new LongestIncreasingSubsequence();
		int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		int result = sub.longestSubsequence(arr);
		System.out.println(result);
	}

	private int longestSubsequence(int[] arr) {
		
		int n = arr.length;
		int max = 0;
		
		int T[] = new int[arr.length];
		int sol[] = new int[arr.length];
		
		for (int i=0; i<n; i++) {
			T[i] = 0;
			sol[i] = i;
		}
		
		for (int i=1; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i]) {
					if (T[i] < (T[j] + 1)) {
						T[i] = T[j] + 1;
						sol[i] = j;
					}
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			if (T[i] > T[max]) {
				max = i;
			}
		}
		
		for (int i=0;i<n;i++)
			System.out.print(sol[i]);
		System.out.println("");
		System.out.println("Max is at position " + max + ", max length of subsequence is " + T[max] + ", max element in subsequence is " + arr[max]);
		
		int currMax = max;
		int j=0;
		System.out.println("Longest subsequence is ");
		do {
			System.out.print(arr[currMax] + " ");
			currMax = sol[currMax];
			j++;
		} while (j<T[max]);
		System.out.println("");
		
		return T[max];
	}

}
