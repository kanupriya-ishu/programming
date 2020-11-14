/*
	Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
	Note: can you take care of the duplicates without using any additional Data Structure?

	Example 1:

	Input:
	n1 = 6; A = {1, 5, 10, 20, 40, 80}
	n2 = 5; B = {6, 7, 20, 80, 100}
	n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
	Output: 20 80
	Explanation: 20 and 80 are the only
	common elements in A, B and C.
	 

	Your Task:  
	You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order. 
	If there are no such elements return an empty array. In this case the output will be printed as -1.

	 

	Expected Time Complexity: O(n1 + n2 + n3)
	Expected Auxiliary Space: O(n1 + n2 + n3)

	 

	Constraints:
	1 <= n1, n2, n3 <= 10^5
	The array elements can be both positive or negative integers.
*/

import java.util.*; 
public class CommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements of array 1:");
		int n1 = sc.nextInt();
		
		int[] arr1 = new int[n1];
		System.out.println("Enter the elements of array 1:");
		for(int i=0; i<n1; i++) {
			arr1[i] = sc.nextInt();
		}
		
		System.out.println("Enter the number of elements of array 2:");
		int n2 = sc.nextInt();
		
		int[] arr2 = new int[n2];
		System.out.println("Enter the elements of array 2:");
		for(int i=0; i<n2; i++) {
			arr2[i] = sc.nextInt();
		}
		
		System.out.println("Enter the number of elements of array 3:");
		int n3 = sc.nextInt();
		
		int[] arr3 = new int[n3];
		System.out.println("Enter the elements of array 3:");
		for(int i=0; i<n3; i++) {
			arr3[i] = sc.nextInt();
		}
		
		sc.close();
		
		int i=0, j=0, k=0;
		boolean flag = false;
		while(i<n1 && j<n2 && k<n3) {
			if (arr1[i]==arr2[j] && arr2[j]==arr3[k]) {
				System.out.println(arr1[i] + " ");
				flag = true;
				i++;
				j++;
				k++;
			}
			
			else if(arr1[i]<arr2[j]) {
				i++;
			}
			
			else if(arr2[j]<arr3[k]) {
				j++;
			}
			else {
				k++;
			}
		}
		
		if(flag==false) {
			System.out.println(-1);
		}
	}

}
