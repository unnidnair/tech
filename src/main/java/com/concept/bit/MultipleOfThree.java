package com.concept.bit;

public class MultipleOfThree {

	public static void main(String[] args) {
		int num = 102;
		if (isMultipleOf3(num))    
	        System.out.println(num + " is multiple of 3");
	    else
	    	System.out.println(num + " is not a multiple of 3");
	}

	private static boolean isMultipleOf3(int n) {
		int odd_count = 0;
	    int even_count = 0;
	    
	    /* Make no positive if +n is multiple of 3
	       then is -n. We are doing this to avoid
	       stack overflow in recursion*/
	    if(n < 0)   n = -n;
	    if(n == 0) return true;
	    if(n == 1) return false;
	    
	    while(n>0)
	    {
	        /* If odd bit is set then
	           increment odd counter */
	        if((n & 1)==1) 
	           odd_count++;
	        n = n>>1;
	 
	        /* If even bit is set then
	           increment even counter */
	        if((n & 1)==1)
	            even_count++;
	        n = n>>1;
	    }
	    
	    return isMultipleOf3(Math.abs(odd_count - even_count));
	}

}
