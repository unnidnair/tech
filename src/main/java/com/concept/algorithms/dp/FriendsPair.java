package com.concept.algorithms.dp;

/*
 * Given n friends, each one can remain single or can be paired up with some other friend. 
 * Each friend can be paired only once. Find out the total number of ways in which friends 
 * can remain single or can be paired up.
 * 
 * http://www.geeksforgeeks.org/friends-pairing-problem/
 * 
 * f(n) = ways n people can remain single 
 *       or pair up.
 *
 *	For n-th person there are two choices:
 *	1) n-th person remains single, we recur 
 *	   for f(n-1)
 *	2) n-th person pairs up with any of the 
 *	   remaining n-1 persons. We get (n-1)*f(n-2)
 *	
 *	Therefore we can recursively write f(n) as:
 *	f(n) = f(n-1) + (n-1)*f(n-2)
 */
public class FriendsPair {

	public static void main(String[] args) {
		FriendsPair pair = new FriendsPair();
		int n = 3;
		System.out.println("Number of possible pairings are " + pair.findPairing(n));
	}

	private int findPairing(int n) {
		
		int sol[] = new int[n+1];
		
		for (int i=0; i<=n; i++) {
			if (i<=2) {
				sol[i] = i;
			} else {
				sol[i] = sol[i-1] + (i-1) * sol[i-2];
			}
		}
		
		return sol[n];
	}
}

//Time Complexity : O(n)
//Auxiliary Space : O(n)
