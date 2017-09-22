package com.questions;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GrouponCountOccurances {

	public static void main(String[] args) {
		GrouponCountOccurances solution = new GrouponCountOccurances();
		String[] data = { 
				"a-3b7622e /home", 
				"b-128a9d7 /home", 
				"a-3b7622e /deals/spa", 
				"b-128a9d7 /deals/car_wash",
				"c-7f8e61a /deals/seattle", 
				"b-128a9d7 /home", 
				"d-d682a11 /deals/car_wash", 
				"a-3b7622e /buy",
				"b-128a9d7 /deals/spa", 
				"c-7f8e61a /deals/coffee", 
				"b-128a9d7 /buy",
				"c-7f8e61a /buy" };
		String popularSequence = solution.findPopularSequence(data);
		System.out.print("Popular sequence " + popularSequence);
	}

/*
 * 
 * Given a web log file, find the most popular 3-page path.
 * 
 * You have a web server log file. It's the simplest log format ever, with 2
 * columns: user_id and page. The rows are written chronologically.
 * 
 * Here's an example...
 * 
 * a-3b7622e /home b-128a9d7 /home a-3b7622e /deals/spa b-128a9d7
 * /deals/car_wash c-7f8e61a /deals/seattle b-128a9d7 /home d-d682a11
 * /deals/car_wash a-3b7622e /buy b-128a9d7 /deals/spa c-7f8e61a /deals/coffee
 * b-128a9d7 /buy c-7f8e61a /buy
 * 
 * Problem: Find the most common (popular) 3 page sequence. For example: In the
 * log file above, the answer is /home --> /deals/spa --> /buy because that path
 * has been followed twice (once by a-3b7622e and once by b-128a9d7).
 * 
 */
	public String findPopularSequence(String[] data) {

		String response = null;

		if (null != data) {
			Map<String, List<String>> userVisits = buildUserVisits(data);
			System.out.println("Number of user entries " + userVisits.size());

			Map<String[], Integer> visitFreq = new HashMap<>();

			for (Map.Entry<String, List<String>> entry : userVisits.entrySet()) {
				if (2 < entry.getValue().size()) {
					// http://docs.oracle.com/javase/6/docs/api/java/util/List.html#toArray(T[])
					String visitedPages[] = entry.getValue().toArray(new String[0]);


					
					String[] subArray = Arrays.copyOfRange(visitedPages, 0, 3);
					visitFreq.put(subArray, null == visitFreq.get(subArray) ? 1 : visitFreq.get(subArray) + 1);
					System.out.println("Add " + stringFromArray(subArray) + " count " + visitFreq.get(subArray));
					
					if (visitedPages.length > 3) {

						for (int i = 2; i < visitedPages.length - 3; i++) {
							subArray = Arrays.copyOfRange(visitedPages, i, i + 3);
							visitFreq.put(subArray, null == visitFreq.get(subArray) ? 1 : visitFreq.get(subArray) + 1);
							System.out.println("Add " + stringFromArray(subArray) + " count " + visitFreq.get(subArray));
						}
					}

				}
			}

			System.out.println("Number of sequence 3 or more are " + visitFreq.size());

			int mostVisitedCount = 0;
			String[] mostVisitedSeq = {};

			for (Map.Entry<String[], Integer> entry : visitFreq.entrySet()) {
				
				StringBuilder sb = toStringArray(entry);
				System.out.println(sb.toString() + ":" + entry.getValue());
				
				if (entry.getValue() > mostVisitedCount) {
					mostVisitedCount = entry.getValue();
					mostVisitedSeq = entry.getKey();
				}
			}
			System.out.println("Most visited " + mostVisitedSeq.toString());
			System.out.print(" count " + mostVisitedCount);

			if (null == mostVisitedSeq)
				response = "";
			else {
				StringBuilder sb = stringFromArray(mostVisitedSeq);
				response = sb.toString();
			}

		} else {
			response = "";
		}
		return response;
	}

	private StringBuilder stringFromArray(String[] subArray) {
		StringBuilder sb = new StringBuilder();
		for (String a : subArray ) {
			sb.append(a).append(",");
		}
		return sb;
	}

	private StringBuilder toStringArray(Map.Entry<String[], Integer> entry) {
		StringBuilder sb = new StringBuilder();
		for (String a : entry.getKey() ) {
			sb.append(a).append(",");
		}
		return sb;
	}

	private Map<String, List<String>> buildUserVisits(String[] data) {
		Map<String, List<String>> userVisits = new HashMap<>();
		for (String datum : data) {
			String keys[] = datum.split(" ");
			List<String> userVisit = userVisits.get(keys[0]);
			if (null == userVisit) {
				userVisit = new ArrayList<>();
				userVisit.add(keys[1]);
				userVisits.put(keys[0], userVisit);
			} else {
				userVisit.add(keys[1]);
			}
		}
		return userVisits;
	}
}
