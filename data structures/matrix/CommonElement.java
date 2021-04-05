/*
Question:
Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.
Example: 

Input:
mat[4][5] = {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };

Output: 
1 8 or 8 1
8 and 1 are present in all rows.
*/

import java.util.*;
public class CommonElement {

    public static void main(String args[]) 
    {  
    	int m[][]= {
    	        {1, 2, 1, 4, 8},
    	        {3, 7, 8, 5, 1},
    	        {8, 7, 7, 3, 1},
    	        {8, 1, 2, 7, 9},
    	    };
    	int rows = m.length;
    	int cols = m[0].length;
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	// fill the HashMap with first row elements as key with a count of 1 as value
    	for(int j=0; j<cols; j++) {
    		map.put(m[0][j], 1);
    	}
    	
    	for(int i=1; i<rows; i++) {
    		for(int j=0; j<cols; j++) {
    			
    			// if the element is present in HashMap and is not duplicated in the row
    			if(map.get(m[i][j])!=null && map.get(m[i][j])==i) {
    				map.put(m[i][j], i+1); //increment the count of element
    				
    				if(i==rows-1) // if it is the last row
    				{
    					System.out.print(m[i][j] + " ");
    				}
    			}
    		}
    	}
  }
}