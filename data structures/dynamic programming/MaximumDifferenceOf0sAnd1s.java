/*
Question:
Given a binary string of 0s and 1s. The task is to find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.

Note: In the case of all 1s, the answer will be -1.

Example 1:

Input : S = "11000010001" 
Output : 6 
Explanatio: From index 2 to index 9, 
there are 7 0s and 1 1s, so number 
of 0s - number of 1s is 6. 

Example 2:

Input: S = "111111"
Output: -1
Explanation: S contains 1s only 
*/

import java.util.*;

public class MaximumDifferenceOf0sAnd1s {

	public static void main(String args[])
	{
		 String s = "11000010001";
		 int n = s.length();
		 System.out.println(maxDifference(s, n));
	}

	private static int maxDifference(String s, int n) {
		
		int[] dp = new int[s.length()];
		
		// fill the dp array
		// if value at string is 0, put 1 in dp
		// if value at string is 1, put -1 in dp
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='0') {
				dp[i] = 1;
			}
			else {
				dp[i] = -1;
			}
		}
		
		// apply Kadane's algorithm on the dp array
		// the maximum contiguous sum is the answer 
		int max_sum = 0;
		int max_till_now = 0;
		
		for(int i=0; i<n; i++) {
			max_till_now  = Math.max(max_till_now  + dp[i], dp[i]);
			max_sum = Math.max(max_sum, max_till_now);
		}
		
		if(max_sum==0){
		    return -1;
		}
		
		return max_sum;
	}

}