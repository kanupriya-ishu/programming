/*
Question:
A step array is an array of integers where each element has a difference of at most k with its neighbor. Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
Examples: 
 

Input : arr[] = {4, 5, 6, 7, 6}
           k = 1
           x = 6
Output : 2
The first index of 6 is 2.

Input : arr[] = {20, 40, 50, 70, 70, 60}  
          k = 20
          x = 60
Output : 5
The index of 60 is 5
*/

package solution;
import java.util.*;
public class SearchWhereAdjacentDifferByAtMostK {
	
	public static void main(String[] args) {
		int[] arr = {20, 40, 50, 70, 70, 60}  ;
		int n = arr.length;
		int x = 60;
		int k = 20;
		System.out.println(search(arr, n, x, k));
	}

	private static int search(int[] arr, int n, int x, int k) {
		
		for(int i=0; i<n; i++) {
			if(arr[i]==x) {
				return i;
			}
			
			i += Math.max(1, Math.abs(arr[i]-x)/k);
		}
		return -1;
	}
	
}

