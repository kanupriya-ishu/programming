/*
Given an array arr of size N and an integer K. Find if there's a triplet in the array which sums up to the given integer K.


Example 1:

Input:
N = 6, K = 13
arr[] = [1 4 45 6 10 8]
Output:
true
Explanation:
The triplet {1, 4, 8} in 
the array sums up to 13.
Example 2:

Input:
N = 5, K = 10
arr[] = [1 2 4 3 6]
Output:
true
Explanation:
The triplet {1, 3, 6} in 
the array sums up to 10.

Your Task:
You don't need to read input or print anything. Your task is to complete the function find3Numbers() which takes the array arr[], the size of the array (N) and the sum (X) as inputs and returns True if there exists a triplet in the array arr[] which sums up to X and False otherwise.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 105
*/
import java.util.*;
public class Test {

    public static void main(String args[]) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	int[] arr = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int total = sc.nextInt();
    	sc.close();
    	
    	int i, l, r, sum;
    	boolean flag = false;
    	Arrays.sort(arr);
    	
    	for( i=0; i<arr.length-2; i++) {
    		
    		l = i+1;
    		r = arr.length-1;
    		
    		while(l<r) {
    			sum = arr[i] + arr[l] + arr[r];
    			
    			if(sum==total) {
    				flag = true;
    				System.out.println("Triplets are "+arr[i]+", "+arr[l]+", "+arr[r]);
    				break;
    			}
    			
    			else if(sum<total) {
    				l++;
    			}
    			
    			else {
    				r--;
    			}
    		}
    		
    		if(flag==true)
    			break;
    	}
    	
    	if(flag==false)
    		System.out.println("No triplets found");
    }
    
}