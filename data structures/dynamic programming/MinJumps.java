/*
Question:
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.

Example 1:

Input:
N = 11 
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
Output: 3 
Explanation: 
First jump from 1st element to 2nd 
element with value 3. Now, from here 
we jump to 5th element with value 9, 
and from here we will jump to last. 

Example 2:

Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2 
Explanation: 
First we jump from the 1st to 2nd element 
and then jump to the last element.
*/

import java.util.*;

public class MinJumps {

	public static void main(String args[])
	{
		 int[] arr = {2,0,0,1,0,5} ;
		 int n = arr.length;
		 
		 System.out.println(minJumps(arr, n));
	}

	private static int minJumps(int[] arr, int n) {
		
		int[] dp = new int[n];

		dp[n-1] = 0;
		
		for(int i=n-2; i>=0; i--) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=arr[i] && i+j<n; j++) {
				
				if(dp[i+j]<min && dp[i+j]!=-1) {
					min = dp[i+j];
				}
			}
			
			if(min!=Integer.MAX_VALUE)
				dp[i] = min + 1;
			else {
				dp[i] = -1;
			}
		}
			
		return dp[0];
	}
}