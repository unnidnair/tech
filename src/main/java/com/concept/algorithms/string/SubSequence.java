package com.concept.algorithms.string;

//Given two strings str1 and str2, find if str1 is a subsequence of str2. A subsequence is 
//a sequence that can be derived from another sequence by deleting some elements without 
//changing the order of the remaining elements (source: wiki). Expected time complexity
//is linear.

//implementations below is O(n) where n is the length of str2.
class SubSequence {
	
 // Returns true if str1[] is a subsequence of str2[]
 // m is length of str1 and n is length of str2
 static boolean isSubSequence(String str1, String str2, int m, int n) {
     // Base Cases
     if (m == 0) 
         return true;
     if (n == 0) 
         return false;
          
     // If last characters of two strings are matching
     if (str1.charAt(m-1) == str2.charAt(n-1))
         return isSubSequence(str1, str2, m-1, n-1);

     // If last characters are not matching
     return isSubSequence(str1, str2, m, n-1);
 }
  
 // Driver program
 public static void main (String[] args)  {
     String str1 = "gksrek";
     String str2 = "geeksforgeeks";
     int m = str1.length();
     int n = str2.length();
     boolean res = isSubSequence(str1, str2, m, n);
     if(res)
         System.out.println("Yes");
     else
         System.out.println("No");
 }
}