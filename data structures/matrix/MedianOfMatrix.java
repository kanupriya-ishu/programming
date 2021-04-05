/*
Question:
Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2
*/

import java.util.*;
public class MedianOfMatrix {

    public static void main(String args[]) 
    {  
    	int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
    	int rows = m.length;
    	int cols = m[0].length;
    	
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=0; i<rows; i++) {
    		// minimum element can be found by comparing first element of every row as matrix is row-wise sorted
    		if(m[0][i] < min)
    			min = m[0][i];
    		
    		// maximum element can be found by comparing last element of every row as matrix is row-wise sorted
    		if(m[cols-1][i] > max)
    			max = m[cols-1][i];
    	}
    	
    	int desired = min*max/2;
    	
    	while(min<max) {
    		int mid = min + (max-min)/2;
    		int count = 0; // this will store number of elements in the matrix less than or equal to mid
    		int get = 0; // this will keep count of elements smaller than mid in a row
    		
    		for(int i=0; i<rows; i++) {
    			// binarySearch is an inbuilt method which takes input as an array and number to be found in array
    			// if number is present in array it returns the index of that array
    			// if number is not present is array it returns -(insertion_point)-1 where insertion point is the index where that number will be placed in a sorted matrix
    			get = Arrays.binarySearch(m[i], mid);
    			
    			// if element is not found in array we equate get variable to (absolute value of get - 1) to find elements smaller than searched element
    			if(get<0) {
    				get = Math.abs(get) - 1;
    			}

    			// if element is found in array we check if duplicate numbers are present, if duplicate numbers are present we add 1 to the get value
    			else {
    				while(get<m[i].length && m[i][get] == mid)
    					get++;
    			}
    			
    			count += get;
    		}
    		
    		if(count<desired)
    			min = mid+1; // as median must be greater than selected number
    		else
    			max=mid; // as median must be less than or equal to selected number
    	}
    	
    	System.out.println(min);
  }
}