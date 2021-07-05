/*
Question:
Given a binary matrix. The problem is to find the largest area rectangular sub-matrix with equal number of 1’s and 0’s.

Examples:

Input : mat[][] = { {0, 0, 1, 1},
                    {0, 1, 1, 0},
                    {1, 1, 1, 0},
                    {1, 0, 0, 1} }
Output : 8 sq. units
(Top, left): (0, 0)
(Bottom, right): (3, 1)

Input : mat[][] = { {0, 0, 1, 1},
                    {0, 1, 1, 1} }            
Output : 6 sq. units
*/

import java.util.*;
public class LargestAreaRectangleWithEqual1s0s {

	public static void main(String[] args) {
		int arr[][] = new int[][] { {0, 0, 1, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 0},
          {1, 0, 0, 1} };
        int rows = arr.length;
        int cols = arr[0].length;
        
        maxArea(arr, rows, cols);
	}

	private static void maxArea(int[][] arr, int rows, int cols) {
		int[] dp = new int[rows];
		int maxArea = Integer.MIN_VALUE;
		int maxRecLeft = -1;
		int maxRecRight = -1;
		int maxRecTop = -1;
		int maxRecBottom = -1;
		
		/*
		 * An efficient solution is based on Largest rectangular sub-matrix whose sum is 0 
		 * which reduces the time complexity to O(n^3). First of all consider every ‘0’ in 
		 * the matrix as ‘-1’. Now, the idea is to reduce the problem to 1-D array. We fix 
		 * the left and right columns one by one and find the largest sub-array with 0 sum 
		 * contiguous rows for every left and right column pair. We basically find top and 
		 * bottom row numbers (which have sum zero) for every fixed left and right column 
		 * pair. To find the top and bottom row numbers, calculate sum of elements in every 
		 * row from left to right and store these sums in an array say temp[]. So temp[i] 
		 * indicates sum of elements from left to right in row i. If we find largest subarray 
		 * with 0 sum in temp[], we can get the index positions of rectangular sub-matrix with 
		 * sum equal to 0 (i.e. having equal number of 1’s and 0’s). With this process we can 
		 * find the largest area rectangular sub-matrix with sum equal to 0 (i.e. having 
		 * equal number of 1’s and 0’s). We can use Hashing technique to find maximum length 
		 * sub-array with sum equal to 0 in 1-D array in O(n) time.
		*/
		
		
		for(int left=0; left<cols; left++) {
			Arrays.fill(dp, 0);
			for(int right=left; right<cols; right++) {
				for(int i=0; i<rows; i++) {
					dp[i] += arr[i][right]==1?1:-1;
					
				}
				int top = -1, bottom = -1;
				
				// to store cumulative sum
				int[] sum = new int[dp.length];
				Arrays.fill(sum, 0);
				// it stores sum:index
				HashMap<Integer, Integer> map = new HashMap<>();
				sum[0] = dp[0];
				
				// find cumulative sum 
				for(int j=1; j<dp.length; j++) {
					sum[j] += sum[j-1] + dp[j];
				}
				
				int mlen = 0;
				
				for(int j=0; j<dp.length; j++) {
					// if sum is 0 
					if(sum[j]==0) {
						// it means from starting of array to this point the total sum is 0
						top = 0;
						bottom = j;
						mlen = j+1;
					}
					
					// sum is not there in map put it in map along with index
					else if(!map.containsKey(sum[j])) {
						map.put(sum[j],j);
					}
					else { // if sum exists in map
						// find length by => current index - index of when sum was found last
						// if this value is greater than max length
						if(mlen < j-map.get(sum[j])) {
							// replace max length with that value
							mlen = j - map.get(sum[j]);
							// top will be index of sum found the first time + 1
							top = map.get(sum[j]) + 1;
							// bottom will be current index
							bottom = j;
						}
					}
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

