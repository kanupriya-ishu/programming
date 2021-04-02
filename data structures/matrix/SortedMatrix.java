/*
Question:
Given an NxN matrix Mat. Sort all elements of the matrix.

Example 1:

Input:
N=4
Mat=[[10,20,30,40],
[15,25,35,45] 
[27,29,37,48] 
[32,33,39,50]]
Output:
10 15 20 25 
27 29 30 32
33 35 37 39
40 45 48 50
Explanation:
Sorting the matrix gives this result.
Example 2:

Input:
N=3
Mat=[[1,5,3],[2,8,7],[4,6,9]]
Output:
1 2 3 
4 5 6
7 8 9
Explanation:
Sorting the matrix gives this result.
*/

import java.util.*;
public class SortedMatrix {

    public static void main(String args[]) 
    {  
    	int arr[][] = { { 5, 4, 7 },
                { 1, 3, 8 },
                { 2, 9, 6 } };
    	
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
    	
    	System.out.println(Arrays.toString(arr2));
    }
   
}