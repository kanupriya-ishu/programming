/*
	Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

	Example 1:

	Input:
	5
	4 2 -3 1 6

	Output: 
	Yes

	Explanation: 
	2, -3, 1 is the subarray 
	with sum 0.
	Example 2:

	Input:
	5
	4 2 0 1 6

	Output: 
	Yes

	Explanation: 
	0 is one of the element 
	in the array so there exist a 
	subarray with sum 0.
	Your Task:
	You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false depending upon whether there is a subarray present with 0-sum or not. Printing will be taken care by the drivers code.

	Expected Time Complexity: O(n).
	Expected Auxiliary Space: O(n).

	Constraints:
	1 <= N <= 104
	-105 <= a[i] <= 105
*/

import java.util.*;
public class SubarrayWithSum0 {

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
		
		int sum = 0;
		HashSet<Integer> h = new HashSet<Integer>();
		
		System.out.println("Is there any subarray with sum equal to 0?");
		
		boolean flag=false;
		for(int i=0; i<n; i++) {
			
			sum += arr[i];
			
			// if element is 0 OR sum is 0 OR sum is already present in HashSet , THEN sum of subarray is 0
			
			if (arr[i]==0 || sum==0 || h.contains(sum)) {
				System.out.println("Yes");
				flag = true;
				break;
			}
			
			h.add(sum);
		}
		
		if (flag==false)
			System.out.println("No");
	}

}