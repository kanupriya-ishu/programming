/*

Reference: https://www.youtube.com/watch?v=AoX3BPWNnoE

Question:
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.

Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.
*/

package solution;
import java.util.*;
public class MajorityElement {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3} ;
		int n = arr.length;
		System.out.println(findMajority(arr, n));
	}

	private static int findMajority(int[] arr, int n) {
		
		int el=0;
		int count = 0;
		
		// Moore's Voting Algorithm
		for(int a: arr) {
			if(count == 0) {
				el = a;
			}
			if(el==a) {
				count++;
			}
			else {
				count--;
			}
		}

		int count2 = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == el) {
				count2++;
			}
		}
		
		if(count2>n/2) {
			return el;
		}
		
		return -1;
	}
}

