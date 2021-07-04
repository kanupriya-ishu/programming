/*
Reference: https://www.youtube.com/watch?v=-FgseNO-6Gk

Question:
Given a 2D matrix M of dimensions RxC. Find the maximum sum subarray in it.

Example 1:

Input:
R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
Output:
29

Example 2:

Input:
R=2
C=2
M=[[-1,-2],[-3,-4]]
Output:
-1
Explanation:
Taking only the first cell is the 
optimal choice.
*/

import java.util.*;
public class MaximumSumRectangleInA2DMatrix {

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
            { -8, -3, 4, 2, 1 },
            { 3, 8, 10, 1, 3 },
            { -4, -1, 1, 7, -6 } };
        int rows = arr.length;
        int cols = arr[0].length;
        
        maxSum(arr, rows, cols);
	}

	private static void maxSum(int[][] arr, int rows, int cols) {
		int[] dp = new int[rows];
		int maxRectangleSum = Integer.MIN_VALUE;
		int maxRecLeft = -1;
		int maxRecRight = -1;
		int maxRecTop = -1;
		int maxRecBottom = -1;
		
		/*
		 * Kadane’s algorithm for 1D array can be used to reduce the time complexity to O(n^3)
		 * The idea is to fix the left and right columns one by one and find the maximum 
		 * sum contiguous rows for every left and right column pair. We basically find top 
		 * and bottom row numbers (which have maximum sum) for every fixed left and right 
		 * column pair. To find the top and bottom row numbers, calculate the sum of elements 
		 * in every row from left to right and store these sums in an array say dp[]. 
		 * So dp[i] indicates sum of elements from left to right in row i. If we apply 
		 * Kadane’s 1D algorithm on dp[], and get the maximum sum subarray of dp, this 
		 * maximum sum would be the maximum possible sum with left and right as boundary 
		 * columns. To get the overall maximum sum, we compare this sum with the maximum 
		 * sum so far.*/
		
		
		for(int left=0; left<rows; left++) {
			Arrays.fill(dp, 0);
			for(int right=left; right<cols; right++) {
				for(int i=0; i<rows; i++) {
					dp[i] += arr[i][right];
					
				}
				
				int j;
				int sum=0, max_sum=Integer.MIN_VALUE, s=0, top=0, bottom=0;
				
				for(j=0; j<dp.length; j++) {
					
					if(dp[j]>sum+dp[j]) {
						sum = dp[j];
						s = j;
					}
					else {
						sum += dp[j];
					}
					
					if(sum>max_sum) {
						max_sum = sum;
						top = s;
						bottom = j;
					}
				}
				
				if(max_sum > maxRectangleSum) {
					maxRectangleSum = max_sum;
					maxRecLeft = left;
					maxRecRight = right;
					maxRecTop = top;
					maxRecBottom = bottom;
				}
			}
		}
		System.out.println("Max sum = "+maxRectangleSum);
		System.out.println("(Top, Left)"+"("+maxRecTop+","+maxRecLeft+ ")"+"\n"+
				"(Bottom, Right)"+"("+maxRecBottom+","+maxRecRight+ ")");
	}

}

