/*
Question:
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
*/

import java.util.*;
public class NextPermutation {
	
    public static void main(String args[]) 
    {  
    	char arr[] = { '5','3','4','9','7','6' };
        int n = arr.length;
        int i;
        for(i=n-1; i>0; i--) {
        	if(arr[i-1]<arr[i])
        		break;
        }
        
        if(i==0)
        	System.out.println("Not possible");
        
        else {
        	int x = arr[i-1], min = i;
        	
        	for(int j=i+1; j<n; j++) {
        		if(arr[j]>x && arr[j]<arr[min])
        			min = j;
        	}
        	
        	swap(arr, i-1, min);
        	
        	Arrays.sort(arr, i, n);
        	
        	System.out.print("Ans: ");
        	for(int j=0; j<n; j++) {
        		System.out.print(arr[j]);
        	}
        }
        
    }
    
    static void swap(char ar[], int i, int j) 
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    

}