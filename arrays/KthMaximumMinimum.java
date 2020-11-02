/*
	Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that ll array elements are distinct.

	Examples:

	Input: arr[] = {7, 10, 4, 3, 20, 15}
	k = 3
	Output: 7

	Input: arr[] = {7, 10, 4, 3, 20, 15}
	k = 4
	Output: 10
	
*/

import java.util.*;
public class KthMaximumMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			System.out.println("Enter element "+(i+1));
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the value of k");
		int k = sc.nextInt();
		sc.close();
		Arrays.sort(arr);
		System.out.println("Sorted array is: ");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		
		System.out.println("Maximum kth element in array is " +  arr[n-k]);
		
		System.out.println("Minimum kth element in array is " +  arr[k-1]);
	}
	
}
