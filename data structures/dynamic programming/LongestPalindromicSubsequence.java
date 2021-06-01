/*
Reference: https://www.youtube.com/watch?v=RiNzHfoA2Lo&t=16s

Question:
Given a sequence, find the length of the longest palindromic subsequence in it.

Example 1:

Input: 
Str = "abcebc"
Output: 
4

Example 2:

Input: 
Str = "abcd"
Output: 
1
*/

import java.util.*;

public class LongestPalindromicSubsequence {

	public static void main(String args[])
	{
		String s = "abccbc";
		System.out.println(countPalindromicSubsequence(s));
	}

	private static int countPalindromicSubsequence(String s) {
		
		// dp[i][j] stores length of longest subsequence starting with s[i] and ending with s[j]
		int[][] dp = new int[s.length()][s.length()];
		
		/*
		 * if gap = 0, then fill dp with 1 because when length of string is 1, max length is 1
		 * gap=0 => diagonal elements => if i traverse in rows and j traverse in col
		 * then j-i = 0  => gap = 0
		 * 
		 * if gap = 1, then fill dp with
		 * if first and last character are same
		 * fill dp with 2  => eg aa => 2
		 * else
		 * fill dp with 1 => eg ab => 1
		 * 
		 * for other cases
		 * consider subsequence count(sq) = count(c1 mid c2)  where c1 is first char and c2 last char and middle string apart from c1 and c2
		 * if (c1 = c2 )
		 * fill dp with max( max_len(c1 mid) + max_len(mid c2)) + 2  => eg. abcbc => max(abcb, bcbc) => max(3, 4) = 4
		 * else
		 * fill dp with max_len(mid) + 2  => eg. abba => max_len(bb) + 2 => 4
		 * */
		
		for(int g=0; g<s.length(); g++) {
			for(int i=0, j=g; j<s.length(); j++, i++) {
				if(g==0) {
					dp[i][j] = 1;
				}
				
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = 2;
					}
					else {
						dp[i][j] = 1;
					}
				}
				
				else {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = 2 + dp[i+1][j-1];
					}
					else {
						dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
					}
				}
			}
		}
		
		return dp[0][s.length()-1];
	}
	
}
