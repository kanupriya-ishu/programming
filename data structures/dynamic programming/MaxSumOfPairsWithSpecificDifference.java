/*
Question:
Given an array of integers arr[] and a number K.You can pair two numbers of the array if the difference between them is strictly less than K. The task is to find the maximum possible sum of such disjoint pairs. The Sum of P pairs is the sum of all 2P numbers of pairs.

 

Example 1:

Input  : 
arr[] = {3, 5, 10, 15, 17, 12, 9}
K = 4
Output : 
62
Explanation :
Then disjoint pairs with difference less
than K are, (3, 5), (10, 12), (15, 17)
max sum which we can get is 
3 + 5 + 10 + 12 + 15 + 17 = 62
Note that an alternate way to form 
disjoint pairs is,(3, 5), (9, 12), (15, 17)
but this pairing produces less sum.
 

Example 2:

Input  : 
arr[] = {5, 15, 10, 300}
K = 12
Output : 
25
 
*/

import java.util.*;

public class MaxSumOfPairsWithSpecificDifference {

	public static void main(String args[])
	{
		int[] arr = {13, 21, 11, 2, 12, 4, 14, 28};
		
		int k = 2;
		
		System.out.println(maxSum(arr, k));
	}

	private static int maxSum(int[] arr, int k) {
		int n = arr.length;
		
		if(n<2) {
			return 0;
			
		}
		
		Arrays.sort(arr);

		int[] dp = new int[n];
		
		for(int i=1; i<n; i++) {
			dp[i] = dp[i-1];
			if(arr[i]-arr[i-1]<k) {
				if(i>=2) {
					dp[i] = Math.max(dp[i], dp[i-2]+arr[i]+arr[i-1]);
				}
				
				else {
					dp[i] = Math.max(dp[i], arr[i] + arr[i-1]);
				}
			}
		}
		return dp[n-1];
	}

}