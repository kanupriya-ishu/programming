/*
Question:
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10


Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.
*/

import java.util.*;
public class TrappingRainWater {

    public static void main(String args[]) 
    {  
    	int[] arr = {6,9,9};
    	
    	int N = arr.length;
    	
    	int sum = 0;
    	
    	// array to store maximum value on left side of the element
    	int[] left = new int[N];
    	
    	// array to store maximum value on left side of the element
    	int[] right = new int[N];
    	
    	left[0] = arr[0];
    	for(int i=1; i<N; i++) {
    		left[i] = Math.max(left[i-1], arr[i]);
    	}
    	
    	right[N-1] = arr[N-1];
    	for(int i=N-2; i>=0; i--) {
    		right[i] = Math.max(right[i+1], arr[i]);
    	}
    	
    	// accumulated water on ith bar will be difference between (minimum of left and right highest bars) and height of the bar
    	// total accumulated water will be sum of accumulated water on every bar
    	for(int i=0; i<N; i++) {
    		sum += Math.min(left[i], right[i]) - arr[i];
    	}
    	
    	System.out.println(sum);
    	
    	
    	
    	
    	
    }
    
}