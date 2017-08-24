package com.concept.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings iso = new IsomorphicStrings();
		System.out.println(iso.testIsomorphicStrings("egg", "add"));
		System.out.println(iso.testIsomorphicStrings("egg", "try"));
	}

	private boolean testIsomorphicStrings(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Character> hash = new HashMap<>();
		for (int i=0;i<s1.length();i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			if (hash.containsKey(c1)) {
				if (hash.get(c1)!=c2) return false;
			} else {
				if (hash.containsValue(c2)) return false;
				else hash.put(c1, c2);
			}
		}
		return true;
	}

}
