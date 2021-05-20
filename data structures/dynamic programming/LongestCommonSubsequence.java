/*
Reference: https://www.youtube.com/watch?v=0Ql40Llp09E

Question:
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.

Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.
*/

import java.util.*;

public class LongestCommonSubsequence {

	public static void main(String args[])
	{
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		
		System.out.println(lcs(s1, s2));
		
	}

	private static int lcs(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		
		// dp[i][j] will hold longest subsequence of string s1 from index i to last index and string s2 from index j to last index
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i=n1; i>=0; i--) {
			for(int j=n2; j>=0; j--) {
				// last row and column represent empty character
				if(i==n1 || j==n2) {
					dp[i][j] = 0;
				}
				
				else {
					// if first character is same then the longest subsequence of string will be 1 + lcs((substring of s1 excluding first character) and (substring of s2 excluding first character))
					if(s1.charAt(i)==s2.charAt(j)) {
						dp[i][j] = 1 + dp[i+1][j+1];
					}
					// otherwise longest subsequence of string will be max of (lcs((string s1)and(string s2 excluding first character)), lcs((string s2)and(string s1 excluding first character)))
					else {
						dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
					}
				}
			}
		}
		
		return dp[0][0]; 
	}

}