/*
Question:
Given a height h, count the maximum number of balanced binary trees possible with height h. Print the result modulo 109 + 7.
Note : A balanced binary tree is one in which for every node, the difference between heights of left and right subtree is not more than 1.

Example 1:

Input: h = 2
Output: 3 
Explanation: The maximum number of balanced 
binary trees possible with height 2 is 3. 

Example 2:

Input: h = 3
Output: 15
Explanation: The maximum number of balanced
binary trees possible with height 3 is 15. 
*/

import java.util.*;

public class CountBalancedBinaryTree {

	public static void main(String args[])
	{
		int h = 3;
		System.out.println(countBBT(h));
	}

	private static long countBBT(int h) {
		
		
		int mod = 1000000007;
		
		long[] dp = new long[h+1];
		dp[0] = 1;
		dp[1] = 1;
		
		/*
		Since the difference between the heights of left and right subtree is not more than one, possible heights of left and right part can be one of the following: 
	 		(h-1), (h-2)
			(h-2), (h-1)
			(h-1), (h-1)
			
		count(h) = count(h-1) * count(h-2) + 
			       count(h-2) * count(h-1) + 
			       count(h-1) * count(h-1)
			     = 2 * count(h-1) * count(h-2) + count(h-1) * count(h-1)
			     = count(h-1) * (2*count(h - 2) + count(h - 1))
		*/
		
		for(int i=2; i<=h; i++) {
			dp[i] = ((dp[i-1]%mod) * (2*dp[i-2]%mod+dp[i-1]%mod))%mod ;
		}
		
		return dp[h];
	}

}
