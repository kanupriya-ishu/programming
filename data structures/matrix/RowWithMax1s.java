/*
Problem:
Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).
*/

public class RowWithMax1s {

    public static void main(String args[]) 
    {  
    	int arr[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
    	
    	int rows = arr.length;
    	int cols = arr[0].length;
    	
    	int max=0, max_row=0;
    	int index;
    	for(int i=0; i<rows; i++) {
    		index = first(arr[i],0,cols-1);
    		
    		if(index!=-1 && cols-index>max) {
    			max = cols-index;
    			max_row = i;
    		}
    	}
    	
    	System.out.println("Answer: "+max_row);
    }

	public static int first(int[] sub, int start, int end) {
		if(start<=end) {
			int mid = start + (end-start)/2;
			
			if((mid==0 || sub[mid-1]==0) && sub[mid]==1)
				return mid;
			
			else if(sub[mid]==0) {
				return first(sub, mid+1, end);
			}
			
			else {
				return first(sub, start, mid-1);
			}
			
		}
		
		return -1;
	}
    
    
    
}