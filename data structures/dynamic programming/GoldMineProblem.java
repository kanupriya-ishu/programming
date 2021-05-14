/*
Question:
Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner can start from any row in the first column. From a given cell, the miner can move

to the cell diagonally up towards the right 
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination: 
The path is {(1,0) -> (2,1) -> (2,2)}.

Example 2:

Input: n = 4, m = 4
M = {{1, 3, 1, 5},
     {2, 2, 4, 1},
     {5, 0, 2, 3},
     {0, 6, 1, 2}};
Output: 16
Explaination: 
The path is {(2,0) -> (3,1) -> (2,2) 
-> (2,3)} or {(2,0) -> (1,1) -> (1,2) 
-> (0,3)}.
*/

import java.util.*;

public class GoldMineProblem {

	public static void main(String args[])
	{
		int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };
		int rows = gold.length;
		int cols = gold[0].length;
		int max = maxGold(gold, rows, cols);
		System.out.println(max);
	}

	private static int maxGold(int[][] gold, int rows, int cols) {
		
		int[][] dp = new int[rows][cols];
		
		for(int j=cols-1; j>=0; j--) {
			for(int i=rows-1; i>=0; i--) {
				if(j==cols-1) { // last column
					// in last column you cannot go to right, right up or right down therefore dp[i][j] will be same as gold[i][j]
					dp[i][j] = gold[i][j];
				}
				else if(i==0) { // first row
					// in first row you can only go to right and right down, so dp[i][j] will be value of gold + max of value at right and right down
					dp[i][j] = gold[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
				}
				else if(i==rows-1) { // last row
					// in last row you can only go to right and right up, so dp[i][j] will be value of gold + max of value at right and right up
					dp[i][j] = gold[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
				}
				else {
					// dp[i][j] will be value of gold + max of value at right, right up and right down
					dp[i][j] = gold[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
				}
			}
		}
		
		int max = 0;
		
		// maximum gold will be the max value in the first column
		for(int i=0; i<rows; i++) {
			max = Math.max(max, dp[i][0]);
		}
		return max;
	}
}