/*
Question:
Write a space optimised solution for finding Longest Common Subsequence
*/

import java.util.*;

public class SpaceOptimisedLCS {

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
		int[][] dp = new int[2][n2+1];
	    int bi=0; // in each iteration of outer loop we only, need values from all columns of previous row
		for(int i=n1; i>=0; i--) {
		    bi = i & 1; // i&1==0 means even and i&1==1 means odd
			for(int j=n2; j>=0; j--) {
				// last row and column represent empty character
				if(i==n1 || j==n2) {
					dp[bi][j] = 0;
				}
				
				else {
					// if first character is same then the longest subsequence of string will be 1 + lcs((substring of s1 excluding first character) and (substring of s2 excluding first character))
					if(s1.charAt(i)==s2.charAt(j)) {
						dp[bi][j] = 1 + dp[1 - bi][j+1];
					}
					// otherwise longest subsequence of string will be max of (lcs((string s1)and(string s2 excluding first character)) lcs((string s2)and(string s1 excluding first character)))
					else {
						dp[bi][j] = Math.max(dp[bi][j+1], dp[1 - bi][j]);
					}
				}
			}
		}
		
		return dp[0][0]; 
	}

}