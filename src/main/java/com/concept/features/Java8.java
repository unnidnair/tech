package com.concept.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8 implements IFunctional{

	public static void main(String[] args) {
		Java8 java = new Java8();
		java.forEachDemo();
		java.functionalInterface();
		java.streamCollection();
	}

	private void streamCollection() {
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		Stream<Integer> seqStream = myList.stream();
		Stream<Integer> parStream = myList.parallelStream();
		
		parStream.filter(p -> p > 50).forEach(p -> System.out.println("Number " + p));
		seqStream.filter(p -> p > 90).forEach(p -> System.out.println("SeqNumber " + p));
		
		
	}

	private void functionalInterface() {
		Runnable r1 = () -> {
			System.out.println("This is a test");
		};
		r1.run();
		
		IFunctional i1 = (s) -> {
			System.out.println("Trying " + s);
		};
		
		i1.testMethod("functional interface");
		i1.testOne("One");
		IFunctional.testTwo("Two");
	}

	private void forEachDemo() {
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.println("Hello " + i);
			}
		});	
	}

	@Override
	public void testMethod(String s) {
		System.out.println("Try" + s);
	}
	
	

}
