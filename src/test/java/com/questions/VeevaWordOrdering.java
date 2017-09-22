package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
1) A method that takes an input of List of Strings and returns a list of unique strings
Input: “ Is it Sunny”, “ Sunny it is”, “Hello World”, “Hello World”, “hello world”
Output: “ Sunny it is”, “hello world”,

Rules:
   a) two strings are considered the same if the only difference between the two is the uppercase and lowercase characters.
   b) Two strings are considered the same as long as they have the same words in them. In the above example " Is it Sunny" and " Sunny it is" are considered the same.
   c) return the last seen string if multiple strings are the same. In the above example “Hello World”, “Hello World”, “hello world” return “hello world”
   d) The input order needs to be maintained in the output order.
 */
public class VeevaWordOrdering {

	public static void main(String[] args) {
		List<String> inputs = new ArrayList<>();

		inputs.add(" Is it Sunny");
		inputs.add("Hello World");
		inputs.add("Hello World");
		inputs.add("hello world");
		inputs.add(" Sunny it is");
		inputs.add(" Sunny Sunny it is");
		inputs.add(" Sunny it is is");

		VeevaWordOrdering solution = new VeevaWordOrdering();
		List<String> outputs = solution.getUniqueStrings(inputs);

		for (String phrase : outputs) {
			System.out.println(phrase);
		}
	}

	public List<String> getUniqueStrings(List<String> strings) {

		List<String> output = new ArrayList<>();

		Map<String[], String> uniqueStrings = new LinkedHashMap<>();

		for (String string : strings) {

			String lowerCase = string.toLowerCase();
			String[] key = lowerCase.split(" ");

			String[] existingKey = findMatch(key, uniqueStrings.keySet());
			// System.out.println("Existing entry for " + string + " is " +
			// arrayToString(existingKey));

			if (null == existingKey || existingKey.length == 0) {
				// System.out.println("Adding entry as " + arrayToString(key) +
				// " for " + string);
				uniqueStrings.put(key, string);
			} else {
				// System.out.println("Updating entry " +
				// arrayToString(existingKey) + " with " + string);
				uniqueStrings.remove(existingKey);
				uniqueStrings.put(existingKey, string);
			}
		}

		for (Map.Entry<String[], String> entry : uniqueStrings.entrySet()) {
			output.add(entry.getValue());
		}

		return output;
	}

	private String[] findMatch(String[] keys, Set<String[]> existingSentences) {
		String[] match = null;

		// System.out.println("Finding match for " + arrayToString(keys));
		if (!existingSentences.isEmpty()) {

			for (String[] existingWordsOnSentence : existingSentences) {

				Map<String, Integer> wordCounter = new HashMap<>();
				for (String word : existingWordsOnSentence) {
					if (null!=word && !word.isEmpty()) 
						if (null == wordCounter.get(word))
							wordCounter.put(word, 1);
						else
							wordCounter.put(word, wordCounter.get(word) + 1);
				}
				System.out.println(wordCounter.size());

				// System.out.println("Comparing " + arrayToString(keys) + " and
				// " + arrayToString(keyFromKeys));
				if (null != existingWordsOnSentence && existingWordsOnSentence.length == keys.length) { // Probable
																										// match
					match = existingWordsOnSentence; 

					List<String> elements = Arrays.asList(existingWordsOnSentence); 
					Map<String, Integer> counter = new HashMap<>();
					for (String key : keys) { // compare every element
						if (!elements.contains(key.toLowerCase())) {
							match = null;
							break; // oops
						} else {
							if (null!=key && !key.isEmpty() && wordCounter.containsKey(key.toLowerCase())) {
								int count = wordCounter.get(key.toLowerCase());
								if (count > 1) {
									wordCounter.put(key, --count);
								} else {
									wordCounter.remove(key);
								}
							}
						}
					}
					if (wordCounter.size() > 0)
						match = null;
					if (null != match) { // found a match
						break;
					}
				}
			}
		} else {
			// System.out.println("Nothing stored");
		}
		// System.out.println("Match found " + !arrayToString(match).isEmpty());
		return match;
	}

	private String arrayToString(String[] arr) {
		StringBuilder sb = new StringBuilder();
		if (null != arr)
			for (String a : arr)
				sb.append(a).append(" ");
		return sb.toString();
	}

}