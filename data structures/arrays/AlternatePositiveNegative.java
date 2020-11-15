/*
	Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
	Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

	Examples :

	Input:  arr[] = {1, 2, 3, -4, -1, 4}
	Output: arr[] = {-4, 1, -1, 2, 3, 4}

	Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
	output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
*/

import java.util.*;
public class AlternatePositiveNegative {

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
		
		// place all negative elements in the end
		int j=n-1;
		int i=0;
		
		while(i<=j) {
			if(arr[i]<0 && arr[j]>0) {
				swap(arr, i, j);
				i++;
				j--;
			}
			
			else if(arr[i]>0 && arr[j]<0) {
				i++;
				j--;
			}
			
			else if(arr[i]>0) {
				i++;
			}
			
			else {
				j--;
			}
			
		}
		
		// if all the elements are negative OR all the elements are positive
		if(i==0 && i==n) {
			System.out.println(Arrays.toString(arr));
		}
		
		else {
			int k=0;
			while(i<n && k<n) {
				swap(arr, i, k);
				i++;
				k+=2;
			}
			System.out.println(Arrays.toString(arr));
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp =  arr[i];
		arr[i] = arr[j];
		arr[j] =  temp;
	}

}
