/*
Question:
Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.

Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.

Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
*/

package solution;
import java.util.*;
public class FindPairGivenDifference {
	
	public static void main(String[] args) {
		int[] arr = {90, 70, 20, 80, 50};
		int n = arr.length;
		int l = 78;
		System.out.println(findPair(arr, n, l));
	}

	private static int findPair(int[] arr, int n, int l) {
		Arrays.sort(arr);
		
		int i=0, j=1;
		
		while(i<n && j<n) {
			if(i!=j && arr[j]-arr[i]==l) {
				return 1;
			}
			else if(arr[j]-arr[i]<l) {
				j++;
			}
			else {
				i++;
			}
		}
		return -1;
	}

}

