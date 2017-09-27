package com.concept.algorithms;

import java.util.stream.LongStream;

public class Factorial {

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int factorialCount = 3;
		System.out.println(factorial.factorial(factorialCount));
		System.out.println(factorial.calc(factorialCount));
		System.out.println(factorial.java8(factorialCount));
		System.out.println(factorial.java8_1(factorialCount));
	}

	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int fact = 1; // this will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
	//Recursion
	public long calc(long n) {
        if (n <= 1)
            return 1;
        else
            return n * calc(n - 1);
    }
	
	public long java8(int n) {
		return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
	}
	
	public long java8_1(int n) {
		return LongStream.rangeClosed(2, n).reduce(1, Math::multiplyExact);
	}
	
	private static final long[] FACTORIAL_TABLE = initFactorialTable();
	private static long[] initFactorialTable() {
	    final long[] factorialTable = new long[21];
	    factorialTable[0] = 1;
	    for (int i=1; i<factorialTable.length; i++)
	        factorialTable[i] = factorialTable[i-1] * i;
	    return factorialTable;
	}
	public long factorial_dp(final int n) {
	    return FACTORIAL_TABLE[n];
	}
}
