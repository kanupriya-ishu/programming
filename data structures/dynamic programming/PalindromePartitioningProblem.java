/*
Reference: https://www.youtube.com/watch?v=qmTtAbOTqcg

Question:
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".
Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".
*/

import java.util.*;
public class PalindromePartitioningProblem {
	
	public static void main(String[] args) {
		String s = "ababbbabbababa";
		int n = minCuts(s);
		System.out.println(n);
	}

	private static int minCuts(String s) {
		int n = s.length();
		// dp[i][j] stores whether string starting at i and ending at j is palindrome or not
		boolean[][] dp = new boolean[n][n];
		
		for(int g=0; g<n; g++) {
			for(int i=0, j=g; j<n; i++, j++) {
				if(g==0) {
					// if one letter then palindrome
					dp[i][j] = true;
				}
				else if(g==1) {
					// if two letters check whether both are same or not
					dp[i][j] = s.charAt(i)==s.charAt(j);
				}
				
				else {
					// if first and last letter are same and mid part is same then it's palindrome
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		// dp2[i][j] stores the number of cuts required 
		// for palindrome partitioning for string starting at i and ending at j
		int[][] dp2 = new int[n][n];
		
		for(int g=0; g<n; g++) {
			for(int i=0, j=g; j<n; i++, j++) {
				if(g==0) {
					// a single letter is palindrome so 0 cuts
					dp2[i][j] = 0;
				}
				else if(g==1) {
					// if both letters are same then 0 cuts otherwise 1 cut
					dp2[i][j] = s.charAt(i)==s.charAt(j)?0:1;
				}
				else {
					if(dp[i][j]) {
						// if string is palindrome then 0 cuts are required
						dp2[i][j] = 0;
					}
					else {
						/*
						 * start traversing from i to j making cut at each 
						 * */
						int min = Integer.MAX_VALUE;
						for(int k=i; k<j; k++) {
							int left = dp2[i][k];
							int right = dp2[k+1][j];
							
							min = Math.min(min, left+right+1);
						}
						dp2[i][j] = min;
					}
				}
			}
		}
		return dp2[0][n-1];
	}
}
