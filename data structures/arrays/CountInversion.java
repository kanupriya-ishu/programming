/*
	Given an array of integers. Find the Inversion Count in the array. 

	Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
	Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
	 

	Example 1:

	Input: N = 5, arr[] = {2, 4, 1, 3, 5}
	Output: 3
	Explanation: The sequence 2, 4, 1, 3, 5 
	has three inversions (2, 1), (4, 1), (4, 3).
	Example 2:

	Input: N = 5
	arr[] = {2, 3, 4, 5, 6}
	Output: 0
	Explanation: As the sequence is already 
	sorted so there is no inversion count.
	Example 3:

	Input: N = 3, arr[] = {10, 10, 10}
	Output: 0
	Explanation: As all the elements of array 
	are same, so there is no inversion count.
	Your Task:
	You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.
*/

import java.util.*;
public class CountInversion {

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
		
		sc.close();
		
		int count=0;
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[i]) {
					count++;
				}
			}
		}
		
		System.out.println("Answer: "+count);
	}

}
