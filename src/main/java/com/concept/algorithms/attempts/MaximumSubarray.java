package com.concept.algorithms.attempts;

/** Compute largest sum which can be derived from subarray of 
 * a given array 
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(computeLargestSum(a));

	}
	
	static int computeLargestSum(int[] seq) {
	    int globalMax = seq[0];
	    int[] nodeSum = new int[seq.length];
	    nodeSum[0] = seq[0];
	    
	    for (int i=1; i<seq.length; i++) {
	        nodeSum[i]=Math.max(seq[i], nodeSum[i-1] + seq[i]);
	        globalMax = Math.max(nodeSum[i], globalMax);
	    }
	    
	    return globalMax;
	}

}
