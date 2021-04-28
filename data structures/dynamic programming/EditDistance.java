/*
Question:
Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of str1.

Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 
0
Explanation: Both strings are same.
*/

import java.util.*;

public class EditDistance {

	public static void main(String args[])
	{
		String s1 = "sunday";
		String s2 = "saturday";
		 System.out.println(editDistance(s1, s2, s1.length(), s2.length()));
	}
	
	private static int min(int a, int b, int c) {
		return a<b && a<c ? a : (b<c ? b : c);
	}

	private static int editDistance(String s1, String s2, int n1, int n2) {
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i=0; i<=n1; i++) {
			for(int j=0; j<=n2; j++) {
				if(i==0)
					// if string1 is empty then j insertions are required
					dp[i][j] = j; 
				
				else if(j==0)
					// if string2 is empty then i deletions are required
					dp[i][j] = i;
				
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				
				else
					dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j]);
				
			}
		}
		
		return dp[n1][n2];
	}

}