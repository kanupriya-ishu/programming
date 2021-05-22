/*
Reference: https://www.youtube.com/watch?v=UvksR0hR9nA

Question:

Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.

Example 1:

Input:
N = 2, K = 10
Output: 4

Example 2:

Input:
N = 3, K = 5
Output: 3
*/

import java.util.*;

public class EggDroppingProblem {

	public static void main(String args[])
	{
		int n = 2;
		int k = 10;
		
		System.out.println(minAttempts(n, k));
	}

	private static int minAttempts(int n, int k) {
		
		// find min of max => find best of the worst
		// whenever there is luck involved consider the worst
		// whether will egg will survive at a floor or not, it is luck, therefore we will consider the worst in that case
		// to find best in this, we will take min of all the max/ worst we found
		
		int[][] dp = new int[n+1][k+1];
		
		for(int eggs=1; eggs<=n; eggs++) {
			for(int floor=1; floor<=k; floor++) {
				if(eggs==1) {
					// if number of eggs is one, then answer is number of floors
					// because we have to consider worst possibilities
					// so the worst possibility is critical floor does not exist
					// therefore we will have to check on every floor
					dp[eggs][floor] = floor;
				}
				
				else if(floor==1) {
					// if number of floor is 1
					// then in 1 possibility we will find the answer
					// if eggs breaks,  then 1st floor is critical floor
					// but if it does not break then critical floor does not exist
					dp[eggs][floor] = 1;
				}
				
				else {
					
					// find min of max => find best of the worst
					// consider kth floor out of f floors and e eggs
					// there are 2 possibilities
					// if egg breaks => means critical floor is below kth floor => no. of eggs = e - 1, no. of floors = k-1
					// if egg survives => means critical floor is above kth floor => no. of eggs = e, no. of floors = f-k
					// to find worst => we have to consider max of both of these 
					// we need to do this for all the floors
					// after we have found worst of all floors
					// we need to find min of all those values
					// that min will be the answer for that floor with e eggs
					int min = Integer.MAX_VALUE;
					
					
					for(int i=floor-1, j=0; i>=0; i--,j++) {
						int max = Math.max(dp[eggs][i], dp[eggs-1][j]);
						min = Math.min(min, max);
						
					}
					dp[eggs][floor] = min + 1;
				}
			}
		}
		
		return dp[n][k];
	}
}