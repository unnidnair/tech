package com.concept.algorithms.attempts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
//		int nums[] = {3,3};
//		int result[] = sum.twoSum1(nums, 6);
		int nums[] = {2, 7, 11, 15};
		int result[] = sum.twoSum(nums, 9);
		
		if (null!=result)
			System.out.println("Numbers " + result[0] + " : " + result[1]);
		else
			System.out.println("No solution");

	}
	
	//Single parse - best
	public int[] twoSum1(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSum(int[] nums, int target) {
        int[] twoSum = null;
        if (null!=nums && nums.length >=2) {
	        Map<Integer, List<Integer>> counterSet = new HashMap<>();
	        for (int i=0; i<nums.length; i++) {
	        	List<Integer> l = null;
	        	if (null==counterSet.get(nums[i])) 
	        		l = new ArrayList<>();
	        	else 
	        		l = counterSet.get(nums[i]);
        		l.add(i);
        		counterSet.put(nums[i], l);
	        }
	        
	        for (int i=0; i<nums.length; i++) {
	        	boolean found = false;
	            if (counterSet.containsKey(target-nums[i])) {
	            	twoSum = new int[2];
	                twoSum[0]=i; 
	                List<Integer> l = counterSet.get(target-nums[i]);
	                Iterator<Integer> lIter = l.iterator();
	                while(lIter.hasNext()) {
	                	Integer counter = lIter.next();
	                	if (counter==i) continue;
	                	twoSum[1]=counter;
	                	found = true;
	                	break;
	                }
	            }
	            if (found) break;
	        }
        }
        return twoSum;
    }
}
