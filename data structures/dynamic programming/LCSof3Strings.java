/*
Question:
Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences.

Example 1:

Input:
A = "geeks", B = "geeksfor", 
C = "geeksforgeeks"
Output: 5
Explanation: "geeks"is the longest common
subsequence with length 5.

Example 2:

Input: 
A = "abcd", B = "efgh", C = "ijkl"
Output: 0
Explanation: There's no common subsequence
in all the strings.
*/

import java.util.*;

public class LCSof3Strings {

	public static void main(String args[])
	{
		String s1 = "AGGT12";
        String s2 = "12TXAYB";
        String s3 = "12XBA";
		
		System.out.println(lcs(s1, s2, s3));
	}

	private static int lcs(String s1, String s2, String s3) {
		// TODO Auto-generated method stub
		int n1 = s1.length();
		int n2 = s2.length();
		int n3 = s3.length();
		
		int[][][] dp = new int[n1+1][n2+1][n3+1];
		
		for(int i=n1; i>=0; i--) {
			for(int j=n2; j>=0; j--) {
				for(int k=n3; k>=0; k--) {
					if (i==n1 || j==n2 || k==n3) {
						dp[i][j][k] = 0;
					}
					
					else {
						if(s1.charAt(i)==s2.charAt(j) && s2.charAt(j)==s3.charAt(k)) {
							dp[i][j][k] = 1 + dp[i+1][j+1][k+1];
						}
						
						else {
							dp[i][j][k] = Math.max(dp[i+1][j][k], Math.max(dp[i][j+1][k], dp[i][j][k+1]));
						}
					}
				}
			}
		}
		
		return dp[0][0][0];
	}


}