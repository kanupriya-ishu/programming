/*
Question:
Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 
			 
Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6 

*/

import java.util.*;
public class FirstAndLastElement {
	
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int n = arr.length;
		int x = 5;
		
		System.out.println("First: " + first(arr,n,x));
		System.out.println("Last: " + last(arr,n,x));
	}

	private static int first(int[] arr, int n, int x) {
		int l = 0;
		int r = n-1;
		
		int res = -1;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(x>arr[mid]) {
				 l = mid + 1;
			}
			else if(x<arr[mid]) {
				r = mid-1;
			}
			else {
				res = mid;
				r = mid-1;
			}
		}
		return res;
	}

	private static int last(int[] arr, int n, int x) {
		int l = 0;
		int r = n-1;
		
		int res = -1;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(x>arr[mid]) {
				 l = mid + 1;
			}
			else if(x<arr[mid]) {
				r = mid-1;
			}
			else {
				res = mid;
				l = mid + 1;
			}
		}
		return res;
	}

}

