/*
	Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

	Input: 
	The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

	Output:
	For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print -1.

	Constraints:
	1 ≤ T ≤ 100
	1 ≤ N ≤ 107
	0 <= ai <= 107

	Example:
	Input:
	2
	11
	1 3 5 8 9 2 6 7 6 8 9
	6
	1 4 3 2 6 7
	Output:
	3
	2

	Explanation:
	Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.
*/

import java.util.*;
public class MinimumNumberOfJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of testcases: ");
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++)
		{
			System.out.println("Enter number of elements");
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			System.out.println("Enter elements of array");
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
			}
			sc.close();
			int ans = calculateMinimumJumps(arr, n);
			System.out.println("Answer: "+ans);
		}
	}
	
	static int calculateMinimumJumps(int arr[], int n)
	{
		int maximumReachableIndex = arr[0];
		int steps = arr[0];
		int jumps = 1;
		
		for(int i=1; i<n; i++) {
			if(i==n-1) {
				return jumps;
			}
			
			maximumReachableIndex = Math.max(maximumReachableIndex, arr[i]+i);
			
			steps--;
			
			if(steps==0) {
				jumps++;
				
				if(i>maximumReachableIndex) {
					return -1;
				}
				
				steps = maximumReachableIndex - i;
			}
		}
		
		return -1;
	}

}
