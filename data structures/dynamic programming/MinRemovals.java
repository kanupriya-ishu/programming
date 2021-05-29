/*
Question:
Given N integers and K, find the minimum number of elements that should be removed, such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered among the remaining elements. 

Examples: 

Input : a[] = {1, 3, 4, 9, 10, 11, 12, 17, 20} 
          k = 4 
Output : 5 
Explanation: Remove 1, 3, 4 from beginning 
and 17, 20 from the end.

Input : a[] = {1, 5, 6, 2, 8}  K=2
Output : 3
Explanation: There are multiple ways to 
remove elements in this case.
One among them is to remove 5, 6, 8.
The other is to remove 1, 2, 5
*/

import java.util.*;

public class MinRemovals {

	public static void main(String args[])
	{
		int arr[] = {1, 5, 6, 2, 8};
        int n = arr.length;
        int k = 2;
        System.out.print(minRemovals(arr, n, k));
	}

	private static int minRemovals(int[] arr, int n, int k) {
		
		Arrays.sort(arr);
		
		// stores the minimum index such that difference is less than or equal to k
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		
		int min = n-1; // stores the minimum removals
		dp[0] = 0; 
		
		for(int i=1; i<n; i++) {
			dp[i] = i;
			int j = dp[i-1];
			while(arr[i]-arr[j]>k && j!=i) {
				j++;
			}
			dp[i] = j;
			min = Math.min(min, n-(i-j+1));
		}

		return min;
	}
}