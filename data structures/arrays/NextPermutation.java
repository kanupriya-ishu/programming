/*
	Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

	The replacement must be in place and use only constant extra memory.

	 

	Example 1:

	Input: nums = [1,2,3]
	Output: [1,3,2]
	Example 2:

	Input: nums = [3,2,1]
	Output: [1,2,3]
	Example 3:

	Input: nums = [1,1,5]
	Output: [1,5,1]
	Example 4:

	Input: nums = [1]
	Output: [1]
	 

	Constraints:

	1 <= nums.length <= 100
	0 <= nums[i] <= 100
*/

import java.util.*;
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int i = n-2;
		while(i>=0 && arr[i]>=arr[i+1]) {
			i--;
		}
		
		if(i>=0) {
			int j=n-1;
			
			while(arr[j]<=arr[i]) {
				j--;
			}
			
			swap(arr, i, j);
		}
		
		reverse(arr, i+1, n-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

	static void reverse(int[] arr, int i, int j) {
	    while(i < j) swap(arr, i++, j--);
	}

}
