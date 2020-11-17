/*
	Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

	Example 1:

	Input:
	N = 5
	Arr[] = {6, -3, -10, 0, 2}
	Output: 180
	Explanation: Subarray with maximum product
	is  6, -3, -10 which gives product as 180.
	Example 2:

	Input:
	N = 6
	Arr[] = {2, 3, 4, 5, -1, 0}
	Output: 120
	Explanation: Subarray with maximum product
	is 2, 3, 4, 5 which gives product as 120.
	Your Task:
	You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
	Note: Use 64-bit integer data type to avoid overflow.

	Expected Time Complexity: O(N)
	Expected Auxiliary Space: O(1)

	Constraints:
	1 <= N <= 500
	-102 <= Arri <= 102
*/

import java.util.*;
public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();

		int max = arr[0];
		int min = arr[0];
		
		int max_product = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i]<0) {
				int temp = max;
				max = min;
				min = temp;
			}
			
			max = Math.max(arr[i], max*arr[i]);
			min = Math.min(min*arr[i], arr[i]);
			max_product = Math.max(max, max_product);
		}
		
		System.out.println( "Maximum Subarray product is "
                + max_product);
	}

}
