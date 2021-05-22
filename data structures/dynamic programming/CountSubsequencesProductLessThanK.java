/*
Question:
Given a non negative array, find the number of subsequences having product smaller than K.

Examples:

Input : [1, 2, 3, 4] 
        k = 10
Output :11 
The subsequences are {1}, {2}, {3}, {4}, 
{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, 
{1, 2, 3}, {1, 2, 4}

Input  : [4, 8, 7, 2] 
         k = 50
Output : 9
*/

import java.util.*;

public class CountSubsequencesProductLessThanK {

	public static void main(String args[])
	{
		int arr[] = {1, 2, 3, 4};
		int k = 10;
		System.out.println(countSubsequences(arr, k));
	}

	private static int countSubsequences(int[] arr, int k) {
		
		int n = arr.length;
		int[][] dp = new int[k+1][n+1]; // dp[i][j] will represent count of subsequence of 0 to j elements of arr whose product is less than i
		
		for(int i=1; i<=k; i++) {
			 
			for(int j=1; j<=n; j++) {
				// if dp[i][j-1] holds count of subsequence of 0 to j-1 elements of arr whose product is less than i 
				// then dp[i][j] will be at least equal to dp[i][j-1]
				// for eg. if elements are 1, 2, 3 and i is 10
				// then count of [1,2] will also be count of [1,2,3] 
				// that is minimum count will be same till previous element 
				dp[i][j] = dp[i][j-1]; 
				
				// if arr[j-1] is less than or equal to i then only it will have more count otherwise count will be same as before
				if(arr[j-1]<=i && arr[j-1]>0) {
					// eg. if i is 8 and arr[j-1] is 4
					// then we will divide 8/4 which is 2 => i/arr[j-1]
					// we will see the count of product 8 at dp[8][2] 
					// at dp[8][2]  subsequences will be [1][2][1,2] when we multiply 4 to this count will be same as this
					// subsequence will become [1,4][2,4][1,2,4] 
					// and previous count is also there because we stored dp[i][j] = dp[i][j-1]
					// new counts are getting added to this value 
					// to this value 1 will also be added because [4] is also a subsequence
					dp[i][j] += dp[i/arr[j-1]][j-1] + 1;
				}
				
			}
		}
		return dp[k][n];
	}

}