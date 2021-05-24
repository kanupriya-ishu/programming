/*
Question:
Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
â€‹Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.


Example 1:

Input: N = 2
Matrix = {{348, 391},
          {618, 193}}
Output: 1009
Explaination: The best path is 391 -> 618. 
It gives the sum = 1009.

Example 2:

Input: N = 2
Matrix = {{2, 2},
          {2, 2}}
Output: 4
Explaination: No matter which path is 
chosen, the output is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maximumPath() which takes the size N and the Matrix as input parameters and returns the highest maximum path sum.

*/


import java.util.*;

public class MaximumPathSum {

	public static void main(String args[])
	{
		 int cost[][]= {{1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3}};
		 int rows = cost.length;
		 int cols = cost[0].length;
		 System.out.println(maxCost(cost,rows,cols));
	}

	private static int maxCost(int[][] cost, int rows, int cols) {
		
		int[][] dp = new int[rows][cols];
		
		for(int i=rows-1; i>=0; i--) {
			for(int j=cols-1; j>=0; j--) {
				
				if(i==rows-1) {
					dp[i][j] = cost[i][j];
				}
				
				else if(j==0) {
					dp[i][j] = cost[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
				}
				
				else if(j==cols-1) {
					dp[i][j] = cost[i][j] + Math.max(dp[i+1][j-1], dp[i+1][j]);
				}
				
				else {
					dp[i][j] = cost[i][j] + Math.max(dp[i+1][j-1], Math.max(dp[i+1][j], dp[i+1][j+1]));
				}
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		int max = 0;
		for(int j=0; j<cols; j++) {
			max = Math.max(max, dp[0][j]);
		}
		
		return max;
	}

}