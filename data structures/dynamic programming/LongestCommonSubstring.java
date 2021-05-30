/*
Question:
Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.

Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.
*/

import java.util.*;

public class LongestCommonSubstring {

	public static void main(String args[])
	{
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		System.out.println(longestCommonSubstring(s1, s2));
	}

	private static int longestCommonSubstring(String s1, String s2) {
		
		int max = 0;
		int n1 = s1.length();
		int n2 = s2.length();
		
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i=1; i<=n1; i++) {
			for(int j=1; j<=n2; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = 0;
				}
				
				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max;
	}

}
