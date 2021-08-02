/*
Reference: https://www.youtube.com/watch?v=hVl2b3bLzBw

Question:
Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


Example 1:

Input:
N = 4, M = 5
arr1[] = {1, 3, 5, 7}
arr2[] = {0, 2, 6, 8, 9}
Output: 0 1 2 3 5 6 7 8 9
Explanation: Since you can't use any 
extra space, modify the given arrays
to form 
arr1[] = {0, 1, 2, 3}
arr2[] = {5, 6, 7, 8, 9}

Example 2:

Input:
N = 2, M = 3
arr1[] = {10, 12}
arr2[] = {5, 18, 20}
Output: 5 10 12 18 20
Explanation: Since you can't use any
extra space, modify the given arrays
to form 
arr1[] = {5, 10}
arr2[] = {12, 18, 20}
*/

package solution;
import java.util.*;
public class Merge2SortedArrays {
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7};
		int[] arr2 = {0, 2, 6, 8, 9};
		int n1 = arr1.length;
		int n2 = arr2.length;
		merge(arr1, arr2, n1, n2);
	}
	
	private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
 

	private static void merge(int[] arr1, int[] arr2, int n1, int n2) {
		int i, j, gap = n1 + n2;
		for(gap = nextGap(gap); gap>0; gap = nextGap(gap)) {
			for(i = 0; i + gap<n1; i++) {
				if(arr1[i]>arr1[i+gap]) {
					int temp = arr1[i];
					arr1[i] = arr1[i+gap];
					arr1[i+gap] = temp;
				}
			}
			
			for(j=gap>n1?gap-n1:0; i<n1 && j<n2; i++, j++) {
				if(arr1[i]>arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
			}
			
			if(j<n2) {
				for(j=0; j+gap<n2; j++) {
					if(arr2[j]>arr2[j+gap]) {
						int temp = arr1[j];
						arr2[j] = arr2[j+gap];
						arr2[j+gap] = temp;
					}
				}
			}
		
		}
		
		System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
	}
	
}
