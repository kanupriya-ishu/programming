/*
Reference: https://www.youtube.com/watch?v=ww4V7vRIzSk

Question:

You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
N = 4
A[] = {5,3,7,10}
Output: 15
Explanation: The user collects maximum
value as 15(10 + 5)

Example 2:

Input:
N = 4
A[] = {8,15,3,7}
Output: 22
Explanation: The user collects maximum
value as 22(7 + 15)
*/

import java.util.*;
public class OptimalGameStrategy {

    public static void main(String[] args)
    {     
    	int[] arr = {5,3,7,10};
    	System.out.println(maxMoney(arr));
    }

	private static int maxMoney(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		/*
		 * For elements starting from i to j
		 * And player 1 starts the game
		 * Then player 1 has two options either to choose ith element or jth element
		 * if player 1 chooses ith element: then elements left are from i+1 to j 
		 * => player 2 can choose either i+1 or j => player 2 will choose such that player 1 gets minimum element
		 * => player 1 will get min of(element i+2,j and element i+1,j-1)
		 * 
		 * if player 1 chooses jth element: then elements left are from i to j-1 
		 * => player 2 can choose either i or j-1 => player 2 will choose such that player 1 gets minimum element
		 * => player 1 will get min of(element i+1,j-1 and element i,j-2)
		 * 
		 * The max of above two will be stored at dp[i][j] where dp[i][j] represents array starting at i and ending at j
		 */
		for(int g=0; g<n; g++) {
			for(int i=0, j=g; j<n; i++, j++) {
				if(g==0) {
					dp[i][j] = arr[i];
				}
				else if(g==1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				}
				else {
					dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
							arr[j]+Math.min(dp[i+1][j-1], dp[i][j-2]));
				}
			}
		}
		
		return dp[0][n-1];
	}
}
