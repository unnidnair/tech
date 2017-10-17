package com.concept.bit;

/**
 * Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
 * Examples:
 *
 * Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
 * Output: 2
 * 
 * The signed left shift operator "<<" shifts a bit pattern to the left, 
 * and the signed right shift operator ">>" shifts a bit pattern to the right. 
 * The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand. 
 * 
 * The unsigned right shift operator ">>>" shifts a zero  into the leftmost position, 
 * while the leftmost position after ">>" depends on sign extension.
 * 
 * The bitwise & operator performs a bitwise AND operation.
 * 
 * The bitwise ^ operator performs a bitwise exclusive OR operation.
 * 
 * The bitwise | operator performs a bitwise inclusive OR operation.
 * 
 * The unary bitwise complement operator "~" inverts a bit pattern; it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0"
 * 
 * ONLINE -- https://www.miniwebtool.com/bitwise-calculator/bit-shift/
 */

//http://www.geeksforgeeks.org/find-the-element-that-appears-once/

public class AppearOnlyOnce {

	static final int INT_SIZE = 32;
	
	public static void main(String[] args) {
		//int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7,7,7,22};
		//int arr[] = {1,2,2,3,3,5,5,1,6};
		int arr[] = {5,5,5,8};
		//int arr[] = {4,-5,3,4,2,4,-5,-5,4,2,2,-5,2};
		int n = arr.length;
        System.out.println("The element with single occurrence is " + getSingle(arr, n, 3));
	}

	// Method to find the element that occur only once
	//O(n) time complexity and O(1) extra space
//	We can sum the bits in same positions for all the numbers and take modulo with 3. 
//	The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
//	Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
//	Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0;
//	Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
//	Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0;//
//	Sum of fourth bits%3 = (1)%3 = 1;
//	Hence number which appears once is 1000
	private static int getSingle(int[] arr, int n, int mod) {
		int result = 0;
		int result1 = 0;
        int x, sum, sum1;
        
        // Iterate through every bit
        for(int i=0; i<INT_SIZE; i++) {
        	// Find sum of set bits at ith position in all 	array elements
            sum = 0;
            sum1 = 0;
            x = (1 << i);
            System.out.println(i + ":" +x);
            for(int j=0; j<n; j++) {
            	if((arr[j] & x) == 0) sum++;
            	if((arr[j] & x) == x) sum1++;
            	System.out.println("j " + j + ":" + arr[j] + ":" + (arr[j] & x) + ":" + sum + ":" + sum1);
            }
            
            result1 |= (sum1%mod << i);
            
            System.out.println("sum "+ sum + ":"+ sum1 + " mod " + mod + " sum % mod " + (sum%mod) + ":" + (sum1%mod));
            if ((sum % mod) == 0)  {
            	System.out.println("result " + result +  " result|x " + (result|x));
            	result |= x;
            }
            
            
        }
        
        System.out.println("Result 1 is " + result1);
        return result;
	}

}
