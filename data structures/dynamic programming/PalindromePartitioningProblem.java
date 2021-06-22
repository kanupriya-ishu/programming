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
		
		// dp2[i] will store the minimum number of cuts from beginning to the i
		int[] dp2 = new int[n];
		
		for(int j=0; j<n; j++) {
			// if string ending at j is palindrome then 0 cuts are required
			if(dp[0][j]) {
				dp2[j] = 0;
			}
			
			/*
			 * check every suffix from j
			 * if any suffix is palindrome then check the rest of the string
			 * before the suffix in dp2
			 * for all such suffix find the minimum number cuts
			 * dp2 will hold the minimum + 1(the cut made at the suffix)
			 * */
			
			else {
				int min = Integer.MAX_VALUE;
				for(int i=j; i>=0; i--) {
					if(dp[i][j]) {
						min = Math.min(min, dp2[i-1]);
					}
				}
				dp2[j] = min + 1;
			}
		}
		
		return dp2[n-1];
	}
}
