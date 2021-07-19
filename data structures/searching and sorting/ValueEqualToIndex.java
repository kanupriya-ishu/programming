/*
Question:
Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index value.

Example 1:

Input: 
N = 5
Arr[] = {15, 2, 45, 12, 7}
Output: 2
Explanation: Only Arr[2] = 2 exists here.

Example 2:

Input: 
N = 1
Arr[] = {1}
Output: 1
Explanation: Here Arr[1] = 1 exists.
*/

import java.util.*;
public class ValueEqualToIndex {
	
	public static void main(String[] args) {
		int[] arr = {15, 2, 45, 12, 7};
		int n = arr.length;
		System.out.println(valueEqualToIndex(arr, n));
	}

	private static ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			if(arr[i]==i+1) {
				ans.add(arr[i]);
			}
		}
		
		return ans;
	}
}

