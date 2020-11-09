/*
	Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

	There is only one duplicate number in nums, return this duplicate number.

	Example 1:

	Input: nums = [1,3,4,2,2]
	Output: 2
	Example 2:

	Input: nums = [3,1,3,4,2]
	Output: 3
	Example 3:

	Input: nums = [1,1]
	Output: 1
	Example 4:

	Input: nums = [1,1,2]
	Output: 1
*/

import java.util.*;
public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array:");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] count = new int[n];
		
		for(int i=0; i<n; i++) {
			count[arr[i]-1]++;
		}
		
		for(int i=0; i<n; i++) {
			if(count[i]>1) {
				System.out.println("Answer: "+ (i+1));
				break;
			}
		}
	}

}
