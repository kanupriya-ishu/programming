/*
Reference: https://www.youtube.com/watch?v=WpYHNHofwjc

Question:
Given a string, find the longest substring which is palindrome. 

For example, 

Input: Given string :"forgeeksskeegfor", 
Output: "geeksskeeg"

Input: Given string :"Geeks", 
Output: "ee"
*/

import java.util.*;

public class LongestPalindromicSubstring {

	public static void main(String args[])
	{
		String s = "abccbc";
		System.out.println(longestPalindromicSubstring(s));
	}

	private static int longestPalindromicSubstring(String s) {
		
		// dp[i][j] stores whether substring starting with s[i] and ending with s[j] is palindrome or not
		boolean[][] dp = new boolean[s.length()][s.length()];
		int len = 0;
		
		/*
		 * if gap = 0 => j-i = 1, then dp[i][j] = true, because single character is palindromic
		 * if gap = 1 => j-i = 2, then dp[i][j] = true if first and last character are same, otherwise dp[i][j] = false
		 * else => check if first and character are same as well as if middle part i.e. dp[i+1][j-1] then dp[i][j] = true else dp[i][j] = false
		 * if dp[i][j] is true, length will be gap + 1 as gap starts from 0
		 * and gap represents the length of substring - 1
		 * largest gap with dp[i][j] true is the answer
		*/
		for(int g=0; g<s.length(); g++) {
			for(int i=0, j=g; j<s.length(); i++, j++) {
				if(g==0) {
					dp[i][j] = true;
				}
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true; 
					}
					else {
						dp[i][j] = false;
					}
				}
				
				if(dp[i][j])
					len = g+1;
			}
		}
				
		return len;
	}
	
}
