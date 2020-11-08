/*
	Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once) where k > 0. The task is to minimize the difference between the heights of the longest and the shortest tower after modifications, and output this difference.

	Examples:

	Input  : arr[] = {1, 15, 10}, k = 6
	Output :  Maximum difference is 5.
	Explanation : We change 1 to 6, 15 to 
	9 and 10 to 4. Maximum difference is 5
	(between 4 and 9). We can't get a lower
	difference.

	Input : arr[] = {1, 5, 15, 10} 
			k = 3   
	Output : Maximum difference is 8
	arr[] = {4, 8, 12, 7}

	Input : arr[] = {4, 6} 
			k = 10
	Output : Maximum difference is 2
	arr[] = {14, 16} OR {-6, -4}

	Input : arr[] = {6, 10} 
			k = 3
	Output : Maximum difference is 2
	arr[] = {9, 7} 

	Input : arr[] = {1, 10, 14, 14, 14, 15}
			k = 6 
	Output: Maximum difference is 5
	arr[] = {7, 4, 8, 8, 8, 9} 

	Input : arr[] = {1, 2, 3}
			k = 2 
	Output: Maximum difference is 2
	arr[] = {3, 4, 5} 
*/

import java.util.*;
public class MinimizeTheHeights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements in array");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array");
		for(int j=0; j<n; j++)
		{
			arr[j] = sc.nextInt();
		}
		
		System.out.println("Enter value of k");
		int k = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		int small = arr[0] + k;
		int big = arr[n-1] - k;
		int ans = big - small;
		
		if (small>big) {
			int temp = small;
			small = big;
			big = temp;
		}
		
		for(int i=0; i<n; i++) {
			int subtract = arr[i] - k;
			int add = arr[i] + k;
			
			if (add<=big || subtract>=small)
				continue;
			
			if (big-subtract < add-small)
			{
				small = subtract;
			}
			else
			{
				big = add;
			}
				
		}
		
		System.out.println("Answer: "+Math.min(ans, big-small));
	}

}
