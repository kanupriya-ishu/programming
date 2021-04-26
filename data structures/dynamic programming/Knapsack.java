/*
Question:
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3

Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
*/

import java.util.*;

public class Knapsack {

	public static void main(String args[])
	{
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int W, int[] wt, int[] val, int n) {
		int[][] arr = new int[n+1][W+1]; 
		
		for(int i=0; i<=n; i++) {
			for(int w=0; w<=W; w++) {
				if(i==0 || w==0) {
					arr[i][w] = 0;
				}
				else if(wt[i-1]<=w) {
					arr[i][w] = Math.max(val[i-1] + arr[i-1][w-wt[i-1]], arr[i-1][w]);
				}
				else {
					arr[i][w] = arr[i-1][w];
				}
			}
		}
		return arr[n][W];
	}
