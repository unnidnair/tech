package com.concept.algorithms.dp;

public class KnapSack {

	public static void main(String[] args) {
		
		int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
		int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
		
		KnapSack knapSack = new KnapSack();
		int value = knapSack.solve(val, wt, 30);
		System.out.println(value);
	}

	private int solve(int[] val, int[] wt, int sackWeight) {
		
		int K[][]=new int[val.length+1][sackWeight+1];
		
		for (int i=0; i<=val.length; i++) {
			for (int j=0; j<=sackWeight; j++) {
				if (i==0 || j==0) {
					K[i][j]=0;
					continue;
				}
				if (j - wt[i-1] > 0) {
					K[i][j]=Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
				} else {
					K[i][j]=K[i-1][j];
				}
			}
		}
		return K[val.length][sackWeight];
	}

}
