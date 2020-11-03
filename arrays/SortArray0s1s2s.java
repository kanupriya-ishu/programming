/*
	Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

	Input:
	The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

	Output: 
	For each testcase, print the sorted array.

	Constraints:
	1 <= T <= 500
	1 <= N <= 106
	0 <= Ai <= 2

	Example:
	Input :
	2
	5
	0 2 1 2 0
	3
	0 1 0

	Output:
	0 0 1 2 2
	0 0 1
*/

import java.util.*;
public class SortArray0s1s2s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of testcases: ");
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.println("Enter number of elements");
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			System.out.println("Enter an array with 0s, 1s and 2s");
			for(int j=0; j<n; j++)
			{
				arr[j] = sc.nextInt();
			}
			
			int countZero = 0;
			int countOne = 0;
			int countTwo = 0;
			
			for(int j=0; j<n; j++)
			{
				if (arr[j]==0)
				{
					countZero++;
				}
				
				else if(arr[j]==1)
				{
					countOne++;
				}
				else
				{
					countTwo++;
				}
			}
			int len = 0;
			for(int j=0; j<countZero; j++)
			{
				arr[len++] = 0;			
			}
			
			for(int j=0; j<countOne; j++)
			{
				arr[len++] = 1;			
			}
			
			for(int j=0; j<countTwo; j++)
			{
				arr[len++] = 2;			
			}
			
			System.out.println("Sorted array is:");
			for(int j=0; j<n; j++)
			{
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
