/*
Question:
Given a matrix of size R*C. Traverse the matrix in spiral form.

Example 1:

Input:
R = 4, C = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

Example 2:

Input:
R = 3, C = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, R and C as input parameters and returns a list of integers denoting the spiral traversal of matrix. 

Expected Time Complexity: O(R*C)
Expected Auxiliary Space: O(R*C)

Constraints:
1 <= R, C <= 100
0 <= matrixi <= 100
*/

public class SpiralMatrix {

    public static void main(String args[]) 
    {  
    	int arr[][] = {{1, 2, 3, 4},
    	           {5, 6, 7, 8},
    	           {9, 10, 11, 12}};
    	
    	int rows = arr.length;
    	int cols = arr[0].length;
    	
    	int i;
    	int start_row=0, start_col=0;
    	
    	while(start_row<rows && start_col<cols) {
    		
    		for(i=start_col; i<cols; i++) {
    			System.out.print(arr[start_row][i]+" ");
    		}
    		start_row++;
    		
    		for(i=start_row;  i<rows; i++) {
    			System.out.print(arr[i][cols-1] + " ");
    		}
    		cols--;
    		
    		if(start_row<rows) {
    			for(i=cols-1; i>=start_col; i--) {
    				System.out.print(arr[rows-1][i] + " ");
    			}
    			rows--;
    		}
    		
    		if(start_col<cols) {
    			for(i=rows-1; i>=start_row; i--) {
    				System.out.print(arr[i][start_col] + " ");
    			}
    			start_col++;
    		}
    	} 
    	
    }
    
}