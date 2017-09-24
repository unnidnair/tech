package com.concept.algorithms.dp;

/**
 * Given a total and coins of certain denomination with infinite supply, what is the 
 * minimum number of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 * 
 * YouTube -- Bottom up DP - https://youtu.be/Y0ZqKpToTic
 *
 */
public class MinimumCoins {

	public static void main(String[] args) {
		MinimumCoins minimumCoins = new MinimumCoins();
		int total = 13;
		int coins[] = {7, 3, 2, 6};
		int minCoins = minimumCoins.findMinimumNumberOfCoins(total, coins);
		System.out.println("Minimum number of coins required to make " + total + " is " + minCoins);
	}

	private int findMinimumNumberOfCoins(int total, int[] coins) {
		
		int T[] = new int[total]; //Total Number of coins
		int R[] = new int[total]; //To get final answer
		int minCoins = 0;
		
		for (int i=0; i<total; i++) {
			T[i] = Integer.MAX_VALUE;
			R[i] = -1;
		}
		
		T[0]=0;
		
		for (int j=0; j<coins.length;j++) {
			for (int i=1;i<total;i++) {
				if (i >= coins[j]) {
					if (T[i] > T[i - coins[j]]) {
						T[i] = T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		printCoinCombination(R, coins);
		return minCoins;
	}
	
	private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

}
