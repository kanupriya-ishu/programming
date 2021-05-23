/*
Question:
Given a binary matrix mat of size n * m, find out the maximum size square sub-matrix with all 1s.

Example 1:

Input: n = 2, m = 2
mat = {{1, 1}, 
       {1, 1}}
Output: 2
Explaination: The maximum size of the square
sub-matrix is 2. The matrix itself is the 
maximum sized sub-matrix in this case.

Example 2:

Input: n = 2, m = 2
mat = {{0, 0}, 
       {0, 0}}
Output: 0
Explaination: There is no 1 in the matrix.
*/

import java.util.*;

public class MaxSizeSquareWithAll1s {

	public static void main(String args[])
	{
		int[][] arr = {{1, 1}, 
			       {1, 1}};
		
		int n = arr.length;
		int m = arr[0].length;
		
		System.out.println(maxSquare(n, m, arr));
	}

	private static int maxSquare(int n, int m, int arr[][]){
        // code here
        int max_size = 0;
		
		// each element at dp[i][j] will store max square length that can be made if it was the last position of the square
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				// if value at arr is 1
				if(arr[i-1][j-1]==1) {
					// find out left, diagonal, and above element of dp
					int val1 = dp[i][j-1];
					int val2 = dp[i-1][j-1];
					int val3 = dp[i-1][j];
					
					// if all those values are greater than 0, answer will be min of the vaues + 1
					/*
						eg. if arr = [[1,1]    dp = [[1,1]     here last position is calculated as min(1,1,1) + 1 = 2
									  [1,1]]        [[1,2]]       
					*/
					if(val1>0 && val2>0 && val3>0) {
						dp[i][j] = 1 + Math.min(val1, Math.min(val2, val3));
					}
					
					// if values are not greater than 0
					else {
						dp[i][j] = 1; // value will be 1 as only 1 square will be formed at that position
					}
				}
				
				else {
					dp[i][j] = 0; // for all other cases no square will be formed therefore value will be zero
				}
				
				// final answer will be the maximum number in the dp
				if(dp[i][j] > max_size) {
					max_size = dp[i][j];  
				}
			}
		}
		

		
		return max_size;
    }

}