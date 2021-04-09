/*
Question:
Given a string, find the length of the longest repeating subsequence such that the two subsequences don’t have same string character at the same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.

Examples:

Input: str = "abc"
Output: 0
There is no repeating subsequence

Input: str = "aab"
Output: 1
The two subssequence are 'a'(first) and 'a'(second). 
Note that 'b' cannot be considered as part of subsequence 
as it would be at same index in both.

Input: str = "aabb"
Output: 2

Input: str = "axxxy"
Output: 2
*/

import java.util.*;
public class LongestSubsequence {

    public static void main(String args[]) 
    {  
    	String s = "aabb";
    	int n = s.length();
    	
    	int[][] l = new int[n+1][n+1];
    	
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=n; j++) {
    			if(s.charAt(i-1)==s.charAt(j-1) && i!=j) {
    				l[i][j] = l[i-1][j-1] + 1;
    			}
    			else {
    				l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
    			}
    		}
    	}
    	
    	System.out.println(l[n][n]);
    } 
}