/*
	Find the maximum and minimum element in an array
*/

import java.util.*;
public class MaximumMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			System.out.println("Enter element "+(i+1));
			arr[i] = sc.nextInt();
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i=0; i<n; i++)
		{
			if(arr[i]>max)
				max = arr[i];
			
			if(arr[i]<min)
				min = arr[i];
		}
		
		System.out.println("Minimum element: "+min+"\nMaximum element: "+max);
	}

}
