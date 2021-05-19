/*
Question:
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

import java.util.*;

public class RodCuttingProblem {

	public static void main(String args[])
	{
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                            cutRod(arr, size));
	}

	private static int cutRod(int[] arr, int size) {
		int[] np = new int[size + 1];
		np[0] = 0;
		
		for(int i=1; i<size+1; i++) {
			np[i] = arr[i-1];
		}
		
		int[] dp = new int[np.length];
		
		dp[0] = 0;
		dp[1] = np[1];
		
		for(int i=2; i<dp.length; i++) {
			dp[i] = np[i];
			int left = 1;
			int right = i-1;
			
			while(left<=right) {
				if(dp[left] + dp[right] > dp[i]) {
					dp[i] = dp[left] + dp[right];
				}
				left++;
				right--;
			}
		}
		
		return dp[dp.length-1];
	}

}