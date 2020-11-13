/*
	Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.


	Example 1:

	Input:
	N = 4, K = 6
	arr[] = {1, 5, 7, 1}
	Output: 2
	Explanation: 
	arr[0] + arr[1] = 1 + 5 = 6 
	and arr[1] + arr[3] = 5 + 1 = 6.

	Example 2:

	Input:
	N = 4, X = 2
	arr[] = {1, 1, 1, 1}
	Output: 6
	Explanation: 
	Each 1 will produce sum 2 with any 1.

	Your Task:
	You don't need to read input or print anything. Your task is to complete the function getPairsCount() which takes arr[], n and k as input parameters and returns the number of pairs that have sum K.
*/

import java.util.*;
public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the sum");
		int sum = sc.nextInt();
		
		sc.close();
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]+arr[j]==sum) {
					count++;
				}
			}
		}
		
		System.out.println("Answer: "+count);
	}

}
