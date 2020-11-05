/*
	An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
	Examples : 

	Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
	Output: -12 -13 -5 -7 -3 -6 11 6 5
	Note: Order of elements is not important here.
*/

import java.util.*;
public class MoveNegativeElementToOneSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int j=0;
		for(int i=0; i<n; i++)
		{
			if(arr[i]<0)
			{
				if(i!=j)
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
		
		System.out.println("Resultant array: ");
		for(int i: arr)
		{
			System.out.print(i + " ");
		}
	}

}
