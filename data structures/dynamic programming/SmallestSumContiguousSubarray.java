/*
Question:
Given an array containing n integers. The problem is to find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
Examples: 
 

Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
Output : -6
Subarray is {-4, 2, -3, -1} = -6

Input : arr = {2, 6, 8, 1, 4}
Output : 1
*/

import java.util.*;

public class SmallestSumContiguousSubarray {

	public static void main(String args[])
	{
		int[] arr = {3, -4, 2, -3, -1, 7, -5};
		int n = arr.length;
		System.out.println(smallestSum(arr, n));
	}

	private static int smallestSum(int[] arr, int n) {
		
		// Use the same approach of Kadane's algorithm
		int curr_sum = 0;
		int min_sum = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			curr_sum = Math.min(arr[i], curr_sum+arr[i]);
			min_sum = Math.min(min_sum, curr_sum);
		}
		
		return min_sum;
	}

}
