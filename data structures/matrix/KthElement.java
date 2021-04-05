/*
Question:
Given a N x N matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

Example 1:
Input:
N = 4
mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }}
K = 3
Output: 27
Explanation: 27 is the 3rd smallest element.
 

Example 2:
Input:
N = 4
mat[][] =     {{10, 20, 30, 40}
                   {15, 25, 35, 45}
                   {24, 29, 37, 48}
                   {32, 33, 39, 50}}
K = 7
Output: 30
Explanation: 30 is the 7th smallest element.
*/

import java.util.*;
public class KthElement {

    public static void main(String args[]) 
    {  
    	int arr[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {24, 29, 37, 48},
        {32, 33, 39, 50}};
    	
    	int k=7;
    	
    	int rows = arr.length;
    	int cols = arr[0].length;
    	int len=0;
    	
    	int[] arr2 = new int[rows*cols];
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<cols; j++) {
    			arr2[len++]=arr[i][j];
    		}
    	}
    	
    	Arrays.sort(arr2);
    	
    	System.out.println(arr2[k-1]);
  }
}