/*
Question:
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.


Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.

Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)
*/

import java.util.*;

public class LargestSumContiguousSubarray {

	public static void main(String args[])
	{
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        maxSum(arr, n);
	}

	private static void maxSum(int[] arr, int n) {
		
		int i;
		int sum=0, max_sum=0, s=0, start=0, end=0;
		
		for(i=0; i<n; i++) {
			
			if(arr[i]>sum+arr[i]) {
				sum = arr[i];
				s = i;
			}
			else {
				sum += arr[i];
			}
			
			if(sum>max_sum) {
				max_sum = sum;
				start = s;
				end = i;
			}
		}
		
		System.out.println("Maximum sum: "+max_sum + "\nstart="+start+ "\nend="+end);
	}

}
