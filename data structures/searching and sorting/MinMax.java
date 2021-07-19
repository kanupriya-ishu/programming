/*
Question:
Write a function to return minimum and maximum in an array. Your program should make the minimum number of comparisons. 
*/

import java.util.*;
public class MinMax {
	
	public static void main(String[] args) {
		int[] arr = {1000, 11, 445, 1, 330, 3000};
		int n = arr.length;
		minMax(arr, n);
	}

	private static void minMax(int[] arr, int n) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		System.out.println("Min = "+min);
		System.out.println("Max = "+max);
	}

}

