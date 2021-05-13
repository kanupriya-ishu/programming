/*
Question:
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination: 
The two parts are {1, 5, 5} and {11}.

Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be 
partitioned into two such parts.
*/

import java.util.*;

public class SubsetSumSubproblem {

	public static void main(String args[])
	{
		int[] nums = {1, 5, 11, 5};
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum % 2) == 1) {
	        return false;
	    }
	    sum /= 2;

	    int n = nums.length;
		
		/*
			Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. 
			If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.

			Base case: dp[0][0] is true; (zero number consists of sum 0 is true)
			Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]). 
			If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers. 
			Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
		*/
	    boolean[][] dp = new boolean[n+1][sum+1];
	    for (int i = 0; i < dp.length; i++) {
	        Arrays.fill(dp[i], false);
	    }
	    
	    dp[0][0] = true;
	    
	    for (int i = 1; i < n+1; i++) {
	        dp[i][0] = true;
	    }
	    for (int j = 1; j < sum+1; j++) {
	        dp[0][j] = false;
	    }
	    
	    for (int i = 1; i < n+1; i++) {
	        for (int j = 1; j < sum+1; j++) {
	            dp[i][j] = dp[i-1][j];
	            if (j >= nums[i-1]) {
	                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	            }
	        }
	    }
	   
	    return dp[n][sum];
	}
}