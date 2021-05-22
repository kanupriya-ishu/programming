/*
Question:
Given a sequence of positive numbers, find the maximum sum that can be formed which has no three consecutive elements present.
Examples : 

Input: arr[] = {1, 2, 3}
Output: 5
We can't take three of them, so answer is
2 + 3 = 5

Input: arr[] = {3000, 2000, 1000, 3, 10}
Output: 5013 
3000 + 2000 + 3 + 10 = 5013

Input: arr[] = {100, 1000, 100, 1000, 1}
Output: 2101
100 + 1000 + 1000 + 1 = 2101

Input: arr[] = {1, 1, 1, 1, 1}
Output: 4

Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: 27
*/

import java.util.*;

public class MaximumSubsequenceSumNo3Consecutive {

	public static void main(String args[])
	{
		int arr[] = { 100, 1000, 100, 1000, 1 };
        int n = arr.length;
        System.out.println(maxSum(arr, n));
	}

	private static int maxSum(int[] arr, int n) {
		
		int[] sum = new int[n];
		
		if(n>0) {
			sum[0] = arr[0];
		}
		
		if(n>1) {
			sum[1] = arr[0] + arr[1];
		}
		
		if(n>2) {
			sum[2] = Math.max(arr[1] + arr[2], Math.max(arr[0]+arr[2], sum[1]));
		}
		
		for(int i=3; i<n; i++) {
			// sum[i] will be max of 
			// 1) excluding arr[i-2] => arr[i]+arr[i-1]+sum[i-3]
			// 2) excluding arr[i-1] => (arr[i]+sum[i-2]
			// 3) excluding arr[i] => sum[i-1]
			sum[i] = Math.max(arr[i]+arr[i-1]+sum[i-3], Math.max(arr[i]+sum[i-2], sum[i-1]));
		}
		
		return sum[n-1];
	}

}