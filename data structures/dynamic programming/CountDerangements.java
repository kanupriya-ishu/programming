/*
Question:
A Derangement is a permutation of n elements, such that no element appears in its original position. For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
Given a number n, find the total number of Derangements of a set of n elements.

Examples : 

Input: n = 2
Output: 1
For two elements say {0, 1}, there is only one 
possible derangement {1, 0}

Input: n = 3
Output: 2
For three elements say {0, 1, 2}, there are two 
possible derangements {2, 0, 1} and {1, 2, 0}

Input: n = 4
Output: 9
For four elements say {0, 1, 2, 3}, there are 9
possible derangements {1, 0, 3, 2} {1, 2, 3, 0}
{1, 3, 0, 2}, {2, 3, 0, 1}, {2, 0, 3, 1}, {2, 3,
1, 0}, {3, 0, 1, 2}, {3, 2, 0, 1} and {3, 2, 1, 0}
*/

import java.util.*;

public class CountDerangements {

    public static void main(String[] args)
    {     
    	int n = 4;
    	System.out.println(countDerangements(n));
    }

	private static int countDerangements(int n) {
		int[] dp = new int[n+1]; // dp[i] denotes the number of derangements for i number
		
		dp[0] = 0; // no elements so no derangements
		dp[1] = 0; // 1 element => {0} => no derangements possible
		dp[2] = 1; // 2 elements => {0, 1} => {1, 0} => one derangement possible
		
		// Recursive relation to find derangement is:
		// countDer(n) = (n - 1) * [countDer(n - 1) + countDer(n - 2)]
		
		for(int i=3; i<=n; i++) {
			dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
		}
		
		return dp[n];
	}

}
+ 