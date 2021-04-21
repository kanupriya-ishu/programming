/*
Question:
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.

Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.
*/

import java.util.*;

public class LongestCommonSubsequence {

	public static void main(String args[])
	{
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    
	    char[] arr1 = s1.toCharArray();
	    char[] arr2 = s2.toCharArray();
	    
	    int n1 = arr1.length;
	    int n2 = arr2.length;
	    
	    System.out.println("Max length: " + lcs(arr1, arr2, n1, n2));
	}

	private static int lcs(char[] arr1, char[] arr2, int n1, int n2) {
		if(n1==0 || n2==0)
			return 0;
		
		if(arr1[n1-1] == arr2[n2-1])
			return 1 + lcs(arr1, arr2, n1-1, n2-1);
		
		else
			return Math.max(lcs(arr1, arr2, n1, n2-1), lcs(arr1, arr2, n1-1, n2));
	}
	
	
}