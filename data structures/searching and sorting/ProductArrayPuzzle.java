/*
Reference: https://www.youtube.com/watch?v=gREVHiZjXeQ

Question:
Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].

Example 1:

Input:
n = 5
nums[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation: 
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.

Example 2:

Input:
n = 2
nums[] = {12,0}
Output:
0 12
*/

package solution;
import java.util.*;
public class ProductArrayPuzzle {
	
	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 6, 2};
		int n = arr.length;
		System.out.println(Arrays.toString(productArray(arr, n)));
	}

	private static long[] productArray(int[] arr, int n) {
		long[] res = new long[n];
		
		long prod = 1;
		
		// calculate cumulative product from left and store in res
		for(int i=0; i<n; i++) {
			prod *= arr[i];
			res[i] = prod;
		}
		
		// store cumulative product from right in prod
		// multiply left and right products and store in res
		prod = 1;
		for(int i=n-1; i>0; i--) {
			res[i] = res[i-1] * prod;
			prod *= arr[i];
		}
		res[0] = prod;
		
		return res;
	}	
	
}
