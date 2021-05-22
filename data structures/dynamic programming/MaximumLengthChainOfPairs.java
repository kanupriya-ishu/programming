/*
Problem:
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 

Example 1:

Input:
N = 5
P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
Output: 3
Explanation: The given pairs are { {5, 24}, {39, 60},
{15, 28}, {27, 40}, {50, 90} },the longest chain that
can be formed is of length 3, and the chain is
{{5, 24}, {27, 40}, {50, 90}}

Example 2:

Input:
N = 2
P[] = {5 10 , 1 11}
Output: 1
Explanation:The max length chain possible is only of
length one.
*/

import java.util.*;

public class MaximumLengthChainOfPairs {

	public static void main(String args[])
	{
		int arr[][] = {{778 ,887 }, {794 ,916}, {336, 387}, {493, 650}, {363, 422}, {28, 691}, {60, 764}, {541, 927}, {173, 427}, {212, 737}, {369 ,568}, {430 ,783}, {531 ,863}, {68 ,124}, {136 ,930}, {23 ,803}, {59, 70}, {168, 394 },
				{12, 457}, {43, 230}, {374, 422}, {785, 920}, {199, 538}, {316, 325}, {371, 414}, {92, 527}, {957, 981}, {863, 874}, {171, 997}, {282, 306}, {85, 926}, {328, 337}, {506, 847}, {314, 730}};
        int n = arr.length;
        System.out.println(longestChain(arr, n));
	}

	private static int longestChain(int[][] arr, int n) {
		
		int[] dp = new int[n];
		
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));
		
		Arrays.fill(dp, 1);
		int max_len = 0;
		
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[i][0]>arr[j][1]) {
					if(dp[j]>max) {
						max = dp[j];
					}
					dp[i] = max+1;
				}
			}
			
			if(dp[i]>max_len) {
				max_len = dp[i];
			}
		}
		
		return max_len;
		
	}

}