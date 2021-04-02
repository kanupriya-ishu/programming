/*
Question:
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/

public class SearchMatrix {

    public static void main(String args[]) 
    {  
    	int arr[][] = {{1, 2, 3, 4},
    	           {5, 6, 7, 8},
    	           {9, 10, 11, 12}};
    	
    	int rows = arr.length;
    	int cols = arr[0].length;
    	
    	// n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

		// array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

    	int l=0, r=rows*cols-1;
    	int target = 3;
    	boolean flag = false;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		
    		if(arr[mid/cols][mid%cols]==target) {
    			flag=true;
    			break;
    		}
    		
    		else if(arr[mid/cols][mid%cols]<target) {
    			l = mid+1;
    		}
    		
    		else {
    			r = mid-1;
    		}
    	}
    	
    	System.out.println(flag);
    }
    
}