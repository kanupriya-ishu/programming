/*
Question:
Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
*/

import java.util.*;
public class MaximumSizeRectangle {

    public static void main(String args[]) 
    {  
    	int A[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
            };
    	
    	int rows = A.length;
    	int cols = A[0].length;
    	
    	int hist[][] = new int[rows][cols];
    	
    	// consider each row as histogram one by one and update the hist matrix
    	
    	for(int j=0; j<cols; j++) {
    		hist[0][j] = A[0][j];
    	}
    	
    	for(int i=1; i<rows; i++) {
    		for(int j=0; j<cols; j++) {
    			if(A[i][j]==0) { // if current element is zero
    				hist[i][j]=0; // height of bar of histogram in that row will be zero
    			}
    			
    			else {
    				// keep adding current value with above row value to get height of bar
    				hist[i][j] = hist[i-1][j] + A[i][j];
    			}
    		}
    	}
    	
    	int maxRowArea = 0;
    	for(int i=0; i<rows; i++) {
    		int max = largestRectangleArea(hist[i]); // find maximum area of row wise histogram
    		
    		if (max>maxRowArea) {
    			maxRowArea = max; // compare all the maximum areas of row wise histogram to find the largest rectangle
    		}
    	}
    	
    	System.out.println(maxRowArea);
    }
  
    
    public static int largestRectangleArea(int[] heights) {
    	int n = heights.length;
    	int[] left = new int[n]; // stores the first left height which is smaller than current element's height
    	int[] right = new int[n]; // stores the first right height which is smaller than current element's height
    	
    	Stack<Integer> s = new Stack<>();
    	
    	// for every bar find the first left height which is smaller than its own height
    	for(int i=0; i<n; i++) { // fill left
    		if(s.empty()) { // for first element there is no left so 0 is stored in left array
    						 // if for further elements no height is less than its own 0 will be stored in left array
    			left[i] = 0;
    			s.push(i);
    		}
    		
    		else {
    			while(!s.empty() && heights[s.peek()]>=heights[i]) { // till stack is not empty and top of stack is greater than or equal to height of current element
    				s.pop(); // pop the stack
    			}
    			left[i] = s.empty()?0:s.peek()+1; // if stack is empty fill the left array with0 otherwise fill it with (top of stack + 1)
				s.push(i); // push the index of current element in stack
    		}
    	}
    	
    	
    	while(!s.empty()) { // clear stack to reuse for right array
    		s.pop();
    	}
    	
    	
    	// for every bar find the first right height which is smaller than its own height
    	for(int i=n-1; i>=0; i--) { // fill right
    		if(s.empty()) { // for last element there is no right so last index is stored in right array
				 // if for further elements no height is less than its own last index will be stored in right array
    			right[i] = n-1;
    			s.push(i);
    		}
    		
    		else {
    			while(!s.empty() && heights[s.peek()]>=heights[i]) { // till stack is not empty and top of stack is greater than or equal to height of current element
    				s.pop(); // pop the stack
    			}
    			right[i] = s.empty()?n-1:s.peek()-1; // if stack is empty fill the right array with last element otherwise fill it with (top of stack - 1)
				s.push(i); // push the index of current element in stack
    		}
    	}
    	   	
    	int max_area=0; // stores max area
    	for(int i=0; i<n; i++) {
    		max_area = Math.max(max_area, heights[i]*(right[i]-left[i]+1)); // largest area of each bar considered as full can be found by multiplying (height of bar) * (right array element of bar - left array element of bar + 1)
    	}
    	return max_area;
    }

}