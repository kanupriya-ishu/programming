/*
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
	 

	Your Task:
	You don't need to read input or print anything. Complete the function merge() which takes the two arrays arr1[], arr2[] and their sizes n and m, as input parameters. The function does not return anything. Use the given arrays to sort and merge arr1[] and arr2[] in-place. 
	Note: The generated output will print all the elements of arr1[] followed by all the elements of arr[2].


	Expected Time Complexity: O((n+m)*log(n+m))
	Expected Auxiliary Space: O(1)


	Constraints:
	1 <= N, M <= 5*104
	0 <= arr1i, arr2i <= 106
*/

import java.util.*;
public class Merge2SortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements of array 1: ");
		int n1 = sc.nextInt();
		
		int[] arr1 = new int[n1];
		
		System.out.println("Enter elements of array 1: ");
		
		for(int i=0; i<n1; i++) {
			arr1[i] = sc.nextInt();
		}
		
		System.out.println("Enter number of elements of array 2: ");
		int n2 = sc.nextInt();
		
		int[] arr2 = new int[n2];
		
		System.out.println("Enter elements of array 2: ");
		
		for(int i=0; i<n2; i++) {
			arr2[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i=n2-1; i>=0; i--) 
        { 
            int j, last = arr1[n1-1]; 
            for (j=n1-2; j >= 0 && arr1[j] > arr2[i]; j--) 
                arr1[j+1] = arr1[j]; 
            if (j != n1-2 || last > arr2[i]) 
            { 
                arr1[j+1] = arr2[i]; 
                arr2[i] = last; 
            } 
        }
		
		System.out.print("After Merging, First Array is: "); 
        System.out.println(Arrays.toString(arr1)); 
        System.out.print("Second Array is:  "); 
        System.out.println(Arrays.toString(arr2)); 
	}

}
