/*
Question:
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.

Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
*/

package solution;
import java.util.*;
public class RepeatingAndMissing {
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 2, 5, 1};
		int n = arr.length;
		missingRepeated(arr, n);
	}

	private static void missingRepeated(int[] arr, int n) {
		
		for(int i=0; i<n; i++) {
			if(arr[i]!=i+1) {
				int temp = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = temp; 

			}
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i]!=i+1) {
				System.out.println("Repeated number = "+arr[i]);
				System.out.println("Missing number = "+(i+1));
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}


}

