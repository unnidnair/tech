package com.concept.algorithms.dp;

/**
 * Google Question
 * 
 * You are a professional robber planning to rob houses along a street. Each house 
 * has a certain amount of money stashed, the only constraint stopping you from robbing 
 * each of them is that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each 
 * house, determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * https://www.programcreek.com/2014/03/leetcode-house-robber-java/
 */
public class Robber {

	public static void main(String[] args) {
		Robber robber = new Robber();
		int[] nums= {10,20,5};
		System.out.println(robber.rob(nums));
	}

	private int rob(int[] nums) {
		
		if (null==nums || 0==nums.length)
			return 0;
		if (1==nums.length)
			return nums[0];
		
		int[] dp =new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		for (int i=2;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		return dp[nums.length-1];
	}

}
