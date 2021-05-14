/*
Reference: https://www.youtube.com/watch?v=l_nR5X9VmaI
Question:
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins. 

Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.

Example 2:

Input:
n = 10 , m = 4
S[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.
*/

import java.util.*;

public class CoinChange {

	public static void main(String args[])
	{
		int val = 12;
		int[] coins = { 1, 5, 10 };
        System.out.println(calculateWays(val, coins));
	}

	private static int calculateWays(int val, int[] coins) {
		int[] table = new int[val+1];
		table[0] = 1;
		int n = coins.length;
		
		for(int i=0; i<n; i++) {
			for(int j=coins[i]; j<val+1; j++) {
				table[j]+= table[j-coins[i]];
			}
		}
		
		return table[val];
	}
}