package com.concept.features;

@FunctionalInterface
public interface IFunctional {
	
	public void testMethod(String s);
	
	default void testOne(String s) {
		System.out.println("Test Default " + s);
	}
	
	static void testTwo(String s) {
		System.out.println("Test Static " + s);
	}
}
