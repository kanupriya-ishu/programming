/*
Reference: https://www.youtube.com/watch?v=jgps7MXtKRQ

Question:
Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate the maximum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
Examples: 

Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
We get maximum value with option 2.

Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}       
Output : 110 
We get maximum value with one unit of
weight 5 and one unit of weight 3.
*/

import java.util.*;

public class UnboundedKnapsack {

	public static void main(String args[])
	{
		int w = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        int n = val.length;
        System.out.println(unboundedKnapsack(w, n, val, wt));
	}

	private static int unboundedKnapsack(int w, int n, int[] val, int[] wt) {
		
		int[] dp = new int[w+1];
		dp[0] = 0;
		
		for(int i=1; i<=w; i++) {
			int max = 0;
			for(int j=0; j<n; j++) {
				if(wt[j]<=i) {
					int v1 = i-wt[j];
					int v2 = dp[v1];
					int v3 = v2 + val[j];
					max = Math.max(max, v3);
				}
			}
			dp[i] = max;
		}
 		return dp[w];
	}
}