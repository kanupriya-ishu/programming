/*
	Given an array (or string), the task is to reverse the array/string.
	
	Examples : 
	Input  : arr[] = {1, 2, 3}
	Output : arr[] = {3, 2, 1}

	Input :  arr[] = {4, 5, 1, 2}
	Output : arr[] = {2, 1, 5, 4}
*/

import java.util.*;
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			System.out.println("Enter element "+(i+1));
			arr[i] = sc.nextInt();
		}
		
		for(int i=0, j=n-1; i<=(n-1)/2; i++, j--)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		System.out.println("Reversed array is");
		
		for(int element:arr)
		{
			System.out.print(element+" ");
		}
	}

}
