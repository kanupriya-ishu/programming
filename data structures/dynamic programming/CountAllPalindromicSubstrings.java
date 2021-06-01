/*
Reference: https://www.youtube.com/watch?v=XmSOWnL6T_I

Question:
Given a string, the task is to count all palindrome sub string in a given string. Length of palindrome sub string is greater than or equal to 2. 

Examples: 

Input : str = "abaab"
Output: 3
Explanation : 
All palindrome substring are :
 "aba" , "aa" , "baab" 

Input : str = "abbaeae"
Output: 4
Explanation : 
All palindrome substring are : 
"bb" , "abba" ,"aea","eae"
*/

import java.util.*;

public class CountAllPalindromicSubstrings {

	public static void main(String args[])
	{
		String s = "abccbc";
		System.out.println(countPalindromicSubstring(s));
	}

	private static int countPalindromicSubstring(String s) {
		
		// dp[i][j] stores whether substring starting with s[i] and ending with s[j] is palindrome or not
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count = 0;
		
		/*
		 * if gap = 0 => j-i = 1, then dp[i][j] = true, because single character is palindromic
		 * if gap = 1 => j-i = 2, then dp[i][j] = true if first and last character are same, otherwise dp[i][j] = false
		 * else => check if first and character are same as well as if middle part i.e. dp[i+1][j-1] then dp[i][j] = true else dp[i][j] = false
		 * count every time dp[i][j] is true, total count will be the answer
		*/
		for(int g=0; g<s.length(); g++) {
			for(int i=0, j=g; j<s.length(); i++, j++) {
				if(g==0) {
					dp[i][j] = true;
				}
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true; 
					}
					else {
						dp[i][j] = false;
					}
				}
				
				if(dp[i][j])
					count++;
			}
		}
				
		return count;
	}
	
}
