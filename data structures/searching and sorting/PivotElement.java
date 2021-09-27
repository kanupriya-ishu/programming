/*
Question:
Suppose we have a sorted array, and now we rotate it N times, find the pivot element. The pivot element would be the largest element. Also, can you calculate N?
*/

import java.util.*;
public class PivotElement {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int n = arr.length;
		System.out.println(findPivot(arr, n));		
	}

	private static int findPivot(int[] arr, int n) {
		int lo = 0;
		int hi = n-1;
		
		if(arr[lo]<arr[n-1])
			return n-1;
		
		while(lo<hi) {
			int mid = lo + (hi-lo)/2;
			if(arr[mid] < arr[hi]) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		
		return hi-1;
	}
}