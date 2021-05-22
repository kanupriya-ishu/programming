/*
Reference: https://www.youtube.com/watch?v=odrfUCS9sQk

Question:
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6

Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3
*/

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String args[])
	{
		int n = 16;
		
		int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		
		System.out.println(lis(arr, n));
	}

	private static int lis(int[] arr, int n) {
		
		int[] dp = new int[n];
		
		int max_lis = 0;
		
		for(int i=0; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					if(dp[j]>max) {
						max = dp[j];
					}
				}
			}
			
			dp[i] = max + 1;
			if(dp[i]>max_lis) {
				max_lis = dp[i];
			}
		}
		
		return max_lis;
	}

}