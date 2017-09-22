package com.concept.algorithms.dp;

//Dynamic Programming -- Algorithm
//
//Find maximum height of bar from the left end upto an index i in the array left_maxleft_max.
//Find maximum height of bar from the right end upto an index i in the array right_maxright_max.
//Iterate over the \text{height}height array and update ans:
//Add min(max_left[i],max_right[i])−height[i]min(max_left[i],max_right[i])−height[i] to ansans

//Ref -- https://leetcode.com/problems/trapping-rain-water/solution/
//Ref -- http://www.geeksforgeeks.org/trapping-rain-water/
public class TrapRainWater {

	public static void main(String[] args) {
		System.out.println("Maximum water that can be accumulated is " + 
                findWater(arr.length));

	}
	
	static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
	
	// Method for maximum amount of water
    static int findWater(int n) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];
      
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
      
        // Initialize result
        int water = 0;
      
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
           left[i] = Math.max(left[i-1], arr[i]);
      
        // Fill right array
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
           right[i] = Math.max(right[i+1], arr[i]);
      
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
           water += Math.min(left[i],right[i]) - arr[i];
      
        return water;
    }
	

	
//	int trap(vector<int>& height)
//	{
//	    if(height == null)
//	        return 0;	
//	    int ans = 0;
//	    int size = height.size();
//	    vector<int> left_max(size), right_max(size);
//	    left_max[0] = height[0];
//	    for (int i = 1; i < size; i++) {
//	        left_max[i] = max(height[i], left_max[i - 1]);
//	    }
//	    right_max[size - 1] = height[size - 1];
//	    for (int i = size - 2; i >= 0; i--) {
//	        right_max[i] = max(height[i], right_max[i + 1]);
//	    }
//	    for (int i = 1; i < size - 1; i++) {
//	        ans += min(left_max[i], right_max[i]) - height[i];
//	    }
//	    return ans;
//	}

}
