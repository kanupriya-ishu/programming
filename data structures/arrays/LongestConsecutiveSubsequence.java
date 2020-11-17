/*
	Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

	Example 1:

	Input:
	N = 7
	a[] = {2,6,1,9,4,5,3}
	Output: 6
	Explanation: The consecutive numbers 
	here are 1, 2, 3, 4, 5, 6. These 6 
	numbers form the longest consecutive
	subsquence.
	Example 2:

	Input:
	N = 7
	a[] = {1,9,3,10,4,20,2}
	Output: 4
	Explanation: 1, 2, 3, 4 is the longest
	consecutive subsequence.
	Your Task:
	You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 

	Expected Time Complexity: O(N).
	Expected Auxiliary Space: O(N).

	Constraints:
	1 <= N <= 105
	0 <= a[i] <= 105
*/

import java.util.*;
public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		HashSet<Integer> set = new HashSet<Integer>();
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			set.add(arr[i]);
		}
		
		for(int i=0; i<n; i++) {
			if (!set.contains(arr[i]-1)) {
				int j=arr[i];
				while(set.contains(j)) {
					j++;
				}
				
				ans = Math.max(ans, j-arr[i]);
			}
		}
		
		System.out.println("Length of the Longest consecutive subsequence is " + ans);
	}

}