/*
	Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

	Example 1:

	Input:
	N = 5
	arr[] = {1,2,3,-2,5}
	Output: 9
	Explanation: Max subarray sum is 9
	of elements (1, 2, 3, -2, 5) which 
	is a contiguous subarray.
	Example 2:

	Input:
	N = 4
	arr[] = {-1,-2,-3,-4}
	Output: -1
	Explanation: Max subarray sum is -1 
	of element (-1)
	Your Task:
	The task is to complete the function maxSubarraySum() which returns the sum of subarray with maximum sum.

	Expected Time Complexity: O(N).
	Expected Auxiliary Space: O(1).

	Constraints:
	1 ≤ N ≤ 106
-107 ≤ A[i] <= 107
*/

import java.util.*;
public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array");
		for(int j=0; j<n; j++)
		{
			arr[j] = sc.nextInt();
		}
		sc.close();
		
		int max_till_now = arr[0];
		int max_ending_here = arr[0];
		
		for(int j=0; j<n; j++) {
			max_ending_here = Math.max(arr[j], max_ending_here+arr[j]);
			max_till_now = Math.max(max_till_now, max_ending_here);
		}
		
		System.out.println("Largest Sum Contiguous Sub Array: " + max_till_now);
	}

}
