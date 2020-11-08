/*
	Given an array, cyclically rotate an array by one.

	Input:
	The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then following line contains 'n' integers forming the array. 

	Output:
	Output the cyclically rotated array by one.

	Constraints:
	1<=T<=1000
	1<=N<=1000
	0<=a[i]<=1000

	Example:
	Input:
	2
	5
	1 2 3 4 5
	8
	9 8 7 6 4 2 1 3

	Output:
	5 1 2 3 4
	3 9 8 7 6 4 2 1
*/

import java.util.*;
public class CyclicallyRotateArrayByOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of testcases");
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.println("Enter number of elements in array");
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			System.out.println("Enter the elements of array");
			for(int j=0; j<n; j++)
			{
				arr[j] = sc.nextInt();
			}
			
			int temp = arr[n-1];
			for(int j=n-1; j>0; j--)
			{
				arr[j] = arr[j-1];
			}
			
			arr[0] = temp;
			
			System.out.println("After rotation: ");
			for(int element: arr) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
