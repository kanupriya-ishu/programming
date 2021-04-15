/*
Problem:
Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

Example 1:

Input: s = "abab"
Output: 2
Explanation: "ab" is the longest proper 
prefix and suffix. 
Example 2:

Input: s = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper 
prefix and suffix. 
*/

import java.util.*;
public class LongestPrefixSuffix {
	
	public static void main(String args[])
	{
		 String s = "abczrtsabc"; // a ab aba abab ababc    c, bc, abc,
	     System.out.println(longestPrefixSuffix(s));
	}

	private static int longestPrefixSuffix(String s) {
		
		int m = s.length();
		
		int len = 0; // length of previous longest prefix suffix
		int i =1;
		
		int[] lps = new int[m];
		lps[0] = 0;
		
		while(i<m) {
			if(s.charAt(i)==s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len!=0) {
					len = lps[len-1];
				}
				
				else {
					lps[i] = len;
					i++;
				}
			}
		}
		
		int res = lps[m-1];
		
		return res>m/2?m/2:res;
		
	}
}