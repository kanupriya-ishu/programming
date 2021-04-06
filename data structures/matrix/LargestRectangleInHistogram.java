/*
Question:
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12

Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram 
will be 8  and there will be 2 consecutive 
histogram. And hence the area of the 
histogram will be 8x2 = 16.
*/

import java.util.*;
public class LargestRectangleInHistogram {

    public static void main(String args[]) 
    {  
    	int heights[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + largestRectangleArea(heights));
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