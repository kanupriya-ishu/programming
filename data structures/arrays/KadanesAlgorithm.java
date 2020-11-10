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
public class KadanesAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements in array: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int maxTillNow = arr[0];
		int maxTillEnd = arr[0];
		
		for(int i=1; i<n; i++) {
			maxTillEnd = Math.max(arr[i], maxTillEnd+arr[i]);
			maxTillNow = Math.max(maxTillEnd, maxTillNow);
		}
		
		System.out.println("Answer: "+maxTillNow);
		
	}

}