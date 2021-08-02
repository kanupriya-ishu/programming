/*
Reference: https://www.youtube.com/watch?v=7nso5Dgc6CI

Question:
Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with the sum smaller than the given sum value X.


Example 1:

Input: N = 4, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with 
sum less than 2 (-2, 0, 1) and (-2, 0, 3). 

Example 2:

Input: N = 5, X = 12
arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with 
sum less than 12 (1, 3, 4), (1, 3, 5), 
(1, 3, 7) and (1, 4, 5).
*/

package solution;
import java.util.*;
public class CountTripletWithSumSmallerThanX {
	
	public static void main(String[] args) {
		int[] arr = {-2, 0, 1, 3};
		int n = arr.length;
		int x = 2;
		System.out.println(countTriplets(arr, n, x));
	}

	private static int countTriplets(int[] arr, int n, int x) {
		Arrays.sort(arr);
		int count = 0;
		for(int i=0; i<n-2; i++) {
			int j =i+1, k = n-1;
			while(j<k) {
				if(arr[i] + arr[j] + arr[k] >= x) {
					k--;
				}
				else {
					count += k-j;
					j++;
				}
			}
		}
		return count;
	}
}
