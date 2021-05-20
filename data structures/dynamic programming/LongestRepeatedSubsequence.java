/*
Reference: https://www.youtube.com/watch?v=oL7GCrcdaJI

Question:
Given a string str, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 

Exampel 1:

Input: str = "axxxy"
Output: 2
Explanation: The longest repeating subsequenece is "xx".

Example 2:

Input: str = "aab"
output: 1
Explanation: The longest reapting subsequenece is "a".
*/

import java.util.*;

public class LongestRepeatedSubsequence {

	public static void main(String args[])
	{
		String s = "axxxy";
		
		System.out.println(lrs(s));
		
	}

	private static int lrs(String s) {
		int n = s.length();
		
		int[][] dp = new int[n+1][n+1];
		
		for(int i=n; i>=0; i--) {
			for(int j=n; j>=0; j--) {
				if(i==n || j==n) {
					dp[i][j] = 0;
				}
				
				else {
					if(s.charAt(i)==s.charAt(j) && i!=j) {
						dp[i][j] = 1 + dp[i+1][j+1];
					}
					
					else {
						dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
					}
				}
			}
		}
		
		return dp[0][0];
	}

}