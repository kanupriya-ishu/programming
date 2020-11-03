/*
	Given two unsorted arrays that represent two sets (elements in every array are distinct), find union and intersection of two arrays.
	For example, if the input arrays are: 
	arr1[] = {7, 1, 5, 2, 3, 6} 
	arr2[] = {3, 8, 6, 20, 7} 
	Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20} and Intersection as {3, 6, 7}. Note that the elements of union and intersection can be printed in any order.
*/

import java.util.*;
public class UnionAndIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements of array 1");
		int m = sc.nextInt();
		int[] arr1 = new int[m];
		System.out.println("Enter elements of array");
		for(int i=0; i<m; i++)
		{
			arr1[i] = sc.nextInt();
		}
		
		System.out.println("Enter number of elements of array 2");
		int n = sc.nextInt();
		int[] arr2 = new int[n];
		System.out.println("Enter elements of array");
		for(int i=0; i<n; i++)
		{
			arr2[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("Union of two arrays:");
		union(arr1, arr2, m, n);
		
		System.out.println("Intersection of two arrays");
		intersection(arr1, arr2, m, n);
		
	}
	public static int binarySearch(int arr[], int target)
	{
		int l=0;
		int r=arr.length-1;
		
		while(l<=r)
		{
			int mid = l + (r-l)/2;
			if(arr[mid]==target)
			{
				return 1;
			}
			else if(target>arr[mid])
			{
				l = mid+1;
			}
			else
			{
				r=mid-1;
			}
		}
		return -1;
	}
	
	public static void union(int arr1[], int arr2[], int m, int n)
	{
		if(n<m)
		{
			int tempArr[] = arr1;
			arr1 = arr2;
			arr2 = tempArr;
			
			int temp = n;
			n = m;
			m = temp;
		}
		
		Arrays.sort(arr1);
		
		for(int i=0; i<m; i++)
		{
			System.out.print(arr1[i]+" ");
		}
		
		for(int i=0; i<n; i++)
		{
			if (binarySearch(arr1, arr2[i])==-1)
			{
				System.out.print(arr2[i]+" ");
			}
		}
		System.out.println();
	}
	
	public static void intersection(int arr1[], int arr2[], int m, int n)
	{
		if(n<m)
		{
			int tempArr[] = arr1;
			arr1 = arr2;
			arr2 = tempArr;
			
			int temp = n;
			n = m;
			m = temp;
		}
		
		Arrays.sort(arr1);
		
		for(int i=0; i<n; i++)
		{
			if (binarySearch(arr1, arr2[i])!=-1)
			{
				System.out.print(arr2[i]+" ");
			}
		}

}
}
