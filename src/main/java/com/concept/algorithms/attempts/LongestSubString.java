package com.concept.algorithms.attempts;

public class LongestSubString {
	
	public static void main(String[] args) {
		LongestSubString a = new LongestSubString();
		//int length = a.lengthOfLongestSubstring("abcabcbb");
		//int length = a.lengthOfLongestSubstring("aab");
		int length = a.lengthOfLongestSubstring("bbbbb");
		System.out.println("Longest substring is "+ length);
	}
	
    private int lengthOfLongestSubstring(String s) {
    	int len = 0;
    	String substring = "";
        if (null!=s && !s.isEmpty() && s.length()>1) {
        	char[] chars = s.toCharArray();
        	int start=0; len=1;
        	while (start < (chars.length-1)) {
        		int end = start+1;
        		if (chars[end] != chars[start]+1) {
        			start++;end++; continue;
        		}
        		int tempStart = start;
        		int tempEnd = end;
        		while (tempEnd < (chars.length-1) && chars[tempEnd]==chars[tempStart]+1){
        			tempStart++; tempEnd++;
        		}
        		if (len<(tempEnd-start)) {
        			len = (tempEnd-start);
        			substring=s.substring(start, tempEnd--);
        		}
        		start++;
        	}
        }
        System.out.println("Substring is " + substring);
        return len;
    }

}
