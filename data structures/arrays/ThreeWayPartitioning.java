/*
Given an array of size N and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.


Example 1:

Input: 
N = 5
A[] = {1, 2, 3, 3, 4}
[a, b] = [1, 2]
Output: 1
Explanation: One possible arrangement is:
{1, 2, 3, 3, 4}. If you return a valid
arrangement, output will be 1.


Example 2:

Input: N = 3 
A[] = {1, 2, 3}
[a, b] = [1, 3]
Output: 1
Explanation: One possible arrangement 
is: {1, 2, 3}. If you return a valid
arrangement, output will be 1.
*/

import java.util.*;
public class ThreeWayPartitioning {

    public static void main(String args[]) 
    {  
    	int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
    	
    	int lowVal = 20;
    	int highVal = 20;
    	
    	int l=0, r=arr.length-1;
    	
    	for(int i=0; i<r; ) {
    		
    		if(arr[i]<lowVal) {
    			int temp = arr[i];
    			arr[i] = arr[l];
    			arr[l] = temp;
    			l++;
    			i++;
    		}
    		
    		else if(arr[i]>highVal) {
    			int temp = arr[i];
    			arr[i] = arr[r];
    			arr[r] = temp;
    			r--;
    		}
    		
    		else
    			i++;
    	}
    	
    	System.out.println(Arrays.toString(arr));
    }
    
}