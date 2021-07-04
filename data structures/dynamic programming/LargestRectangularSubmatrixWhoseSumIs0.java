/*
Question:
Given a 2D matrix, find the largest rectangular sub-matrix whose sum is 0. 

Examples:

Input :  1,  2,  3
        -3, -2, -1          
         1,  7,  5

Output : 1,  2,  3          
        -3, -2, -1

Input :  9,  7, 16,  5
         1, -6, -7,  3          
         1,  8,  7,  9          
         7, -2,  0, 10

Output :-6, -7
          8,  7          
         -2,  0 
*/

import java.util.*;
public class LargestRectangularSubmatrixWhoseSumIs0 {

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 9, 7, 16, 5 }, { 1, -6, -7, 3 },
            { 1, 8, 7, 9 }, { 7, -2, 0, 10 } };
        int rows = arr.length;
        int cols = arr[0].length;
        
        maxSum(arr, rows, cols);
	}

	private static void maxSum(int[][] arr, int rows, int cols) {
		int[] dp = new int[rows];
		int maxArea = Integer.MIN_VALUE;
		int maxRecLeft = -1;
		int maxRecRight = -1;
		int maxRecTop = -1;
		int maxRecBottom = -1;
		
		/*
		 * The solution is based on Maximum sum rectangle in a 2D matrix. The idea is to 
		 * reduce the problem to 1 D array. We can use Hashing to find maximum length of 
		 * sub-array in 1-D array in O(n) time. We fix the left and right columns one by 
		 * one and find the largest sub-array with 0 sum contiguous rows for every left 
		 * and right column pair. We basically find top and bottom row numbers (which have 
		 * sum is zero) for every fixed left and right column pair. To find the top and 
		 * bottom row numbers, calculate sum of elements in every row from left to right 
		 * and store these sums in an array say temp[]. So temp[i] indicates sum of elements 
		 * from left to right in row i. If we find largest subarray with 0 sum on temp, and 
		 * no. of elements is greater than previous no. of elements then update the values 
		 * of final row_up, final row_down, final col_left, final col_right.
		*/
		
		
		for(int left=0; left<rows; left++) {
			Arrays.fill(dp, 0);
			for(int right=left; right<cols; right++) {
				for(int i=0; i<rows; i++) {
					dp[i] += arr[i][right];
					
				}
				
				HashMap<Integer, Integer> map = new HashMap<>();
				int j = 0;
				int mlen = 0;
				int sum = 0;
				int top = -1;
				int bottom = -1;
				while(j<dp.length) {
					sum += dp[j];
					
					if(map.containsKey(sum)==false) {
						map.put(sum, j);
					}
					else {
						int len = j - map.get(sum);
						if(len > mlen) {
							mlen = len;
							top = map.get(sum)+1;
							bottom = j;
						}
					}
					
					j++;
				}
				
				boolean isSum0 = mlen!=0;
				int area = (right-left+1) * (bottom-top+1);
				if(isSum0 && area > maxArea) {
					maxArea = area;
					maxRecLeft = left;
					maxRecRight = right;
					maxRecTop = top;
					maxRecBottom = bottom;
				}
			}
		}
		
		for(int i=maxRecTop; i<=maxRecBottom; i++) {
			for(int j=maxRecLeft; j<=maxRecRight; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Max area = "+ maxArea);
		System.out.println("(Top, Left)"+"("+maxRecTop+","+maxRecLeft+ ")"+"\n"+
				"(Bottom, Right)"+"("+maxRecBottom+","+maxRecRight+ ")");
	}

}

