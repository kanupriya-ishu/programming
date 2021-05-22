/*
Question:
Given an array A[] of size N, find the longest subsequence such that difference between adjacent elements is one.


Example 1:

Input: N = 7
A[] = {10, 9, 4, 5, 4, 8, 6}
Output: 3
Explaination: The three possible subsequences 
{10, 9, 8} , {4, 5, 4} and {4, 5, 6}.

Example 2:

Input: N = 5
A[] = {1, 2, 3, 4, 5}
Output: 5
Explaination: All the elements can be 
included in the subsequence.

*/

import java.util.*;

public class LongestSubsequencedifferenceBetweenAdjacentIsOne {

	public static void main(String args[])
	{
		int arr[] = {10, 9, 4, 5, 4, 8, 6};
		int n = arr.length;
		System.out.println(longestSubsequence(arr, n));
	}

	private static int longestSubsequence(int[] arr, int n) {
		
		int[] dp = new int[n];
		
		dp[0] = 0;
		int max_len = 0;
		
		for(int i=1; i<n; i++) {
			int max = 0; 
			for(int j=0; j<i; j++) {
				if (Math.abs(arr[i]-arr[j])==1) {
					if(dp[j]>max) {
						max = dp[j];
					}
					dp[i] = max + 1;
				}
			}
			
			
			if(dp[i]>max_len) {
				max_len = dp[i];
			}
		}
		
		return max_len+1;
	}
}