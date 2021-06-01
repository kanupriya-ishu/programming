/*
Reference: https://www.youtube.com/watch?v=YHSjvswCXC8

Question:
Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
Note: You have to return the answer module 109+7;
 

Example 1:

Input: 
Str = "abcd"
Output: 
4
Explanation:
palindromic subsequence are : "a" ,"b", "c" ,"d"
 

Example 2:

Input: 
Str = "aab"
Output: 
4
Explanation:
palindromic subsequence are :"a", "a", "b", "aa"
*/

package test;
import java.util.*;

public class CountPalindromicSubsequence {

	public static void main(String args[])
	{
		String s = "abccbc";
		System.out.println(countPalindromicSubsequence(s));
	}

	private static int countPalindromicSubsequence(String s) {
		
		// dp[i][j] stores number of subsequences starting with s[i] and ending with s[j]
		int[][] dp = new int[s.length()][s.length()];
		
		/*
		 * if gap = 0, then fill dp with 1
		 * gap=0 => diagonal elements => if i traverse in rows and j traverse in col
		 * then j-i = 0  => gap = 0
		 * 
		 * if gap = 1, then fill dp with
		 * if first and last character are same
		 * fill dp with 3  => eg aa => a, a, aa
		 * else
		 * fill dp with 2 => eg ab => a, b
		 * 
		 * for other cases
		 * consider subsequence count(sq) = count(c1 mid c2)  where c1 is first char and c2 last char and middle string apart from c1 and c2
		 * if (c1 = c2 )
		 * fill dp with count(c1 mid) + count(mid c2) + 1
		 * else
		 * fill dp with count(c1 mid) + count(mid c2) + 1
		 * */
		
		for(int g=0; g<s.length(); g++) {
			for(int i=0, j=g; j<s.length(); i++, j++) {
				if(g==0) {
					dp[i][j] = 1;
				}
				
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = 3;
					}
					else {
						dp[i][j] = 2;
					}
				}
				
				else {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = 1 + dp[i][j-1] + dp[i+1][j];
					}
					else {
						dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
					}
				}
			}
		}
		
		return dp[0][s.length()-1];
	}
	
}
