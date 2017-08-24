package com.concept.algorithms;

public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords r1 = new ReverseWords();
		r1.reverseWords("This is a test for reverse".toCharArray());
	}

	private void reverseWords(char[] chars) {
		
		System.out.println(chars);
		int i=0;
		for (int j=0;j<chars.length;j++) {
			if (chars[j] == ' ') {
				reverse(chars, i, j-1);
				i=j+1;
			}
		}
		reverse(chars, i, chars.length-1);
		
		System.out.println(chars);
		reverse(chars, 0, chars.length-1);
		System.out.println(chars);
		
	}

	private void reverse(char[] chars, int start, int end) {
		
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++; end--;
		}
		
	}

}
