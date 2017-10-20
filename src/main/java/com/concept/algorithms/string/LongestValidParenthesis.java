package com.concept.algorithms.string;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		//String s = ")))))()())";  //())())) -- 4
		//String s = "())()))";
		String s = "())()))";
		System.out.println(longestValidParentheses(s ));

	}
	
	public static int longestValidParentheses(String s) {
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;
	 
		for(int i=0; i<=s.length()-1; i++){
			char c = s.charAt(i);
			if(c=='('){
				int[] a = {i,0};
				stack.push(a);
				System.out.println("push ( " + i);
			}else{
				if(stack.empty()||stack.peek()[1]==1){
					int[] a = {i,1};
					stack.push(a);
					System.out.println("push ) " + i);
				}else{
					stack.pop();
					System.out.println("pop " + i);
					int currentLen=0;
					if(stack.empty()){
						currentLen = i+1;
						System.out.println("current length (empty) " + (i+1));
					}else{
						currentLen = i-stack.peek()[0];
						System.out.println("current length (non) " + (i-stack.peek()[0]));
					}
					result = Math.max(result, currentLen);
				}
			}
		}
	 
		return result;
	}

}
