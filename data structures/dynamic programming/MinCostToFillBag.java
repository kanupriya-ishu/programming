/*
Question:
Given an array cost[] of positive integers of size N and an integer W, cost[i] represents the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges. If it is not possible to buy exactly W kg oranges then the output will be -1

Note:
1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
2. It may be assumed that there is infinite supply of all available packet types.

Example 1:

Input: N = 5, arr[] = {20, 10, 4, 50, 100}
W = 5
Output: 14
Explanation: choose two oranges to minimize 
cost. First orange of 2Kg and cost 10. 
Second orange of 3Kg and cost 4. 

Example 2:

Input: N = 5, arr[] = {-1, -1, 4, 3, -1}
W = 5
Output: -1
Explanation: It is not possible to buy 5 
kgs of oranges
*/

import java.util.*;

public class MinCostToFillBag {

	public static void main(String args[])
	{
		int val[] = {-1, 15, -1, 3, 14, 13, 10, 10};
		int w = 810;
        int n = val.length;
        System.out.println(minCost(val, w, n));
	}

	private static int minCost(int[] cost, int w, int n) {
		
	 	Vector<Integer> val = new Vector<Integer>();
        Vector<Integer> wt = new Vector<Integer>();
      
        // traverse the original cost[] array and skip
        // unavailable packets and make val[] and wt[]
        // array. size variable tells the available
        // number of distinct weighted packets
        int size = 0;
        for (int i = 0; i < n; i++)
        {
            if (cost[i] != -1)
            {
                val.add(cost[i]);
                wt.add(i + 1);
                size++;
            }
        }
        
        n = size;
        
        // Further steps are same as unbounded knapsack
        // Instead of finding max, find min
		int[] dp = new int[w+1];	
		dp[0] = 0;
		for(int i=1; i<=w; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				if(wt.get(j)<=i) {
					int v1 = i-wt.get(j);
					int v2 = dp[v1];
					if(v2!=-1) {
						int v3 = v2 + val.get(j);
						min = Math.min(min, v3);
					}
				}
			}
			dp[i] = min==Integer.MAX_VALUE?-1:min;
		}

		return dp[w];
	}
	

}