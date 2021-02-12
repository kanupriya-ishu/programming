/*
Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

Input:
The first line of input contains an integer denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains an integer n denoting the size of the arrays. In the second line are N space separated values of the array A[].

Output:
For each test case in a new line print the required result.

Constraints:
1 <=T<= 50
1 <=n<= 20
1 <=A[]<= 10000

Example:
Input:
2
5
111 222 333 444 555
3
121 131 20

Output:
1
0

Explanation:
For First test case.
n=5;
A[0] = 111    //which is a palindrome number.
A[1] = 222   //which is a palindrome number.
A[2] = 333   //which is a palindrome number.
A[3] = 444  //which is a palindrome number.
A[4] = 555  //which is a palindrome number.
As all numbers are palindrome so This will return 1.
*/

import java.util.*;
public class PalindromeArray {

    public static void main(String args[]) 
    {  
    	int[] arr = {121, 131, 20};
    	
    	int n = arr.length;
    	boolean flag = false;
    	
    	for(int i=0; i<n; i++) {
    		
    		int rev = 0;
    		int temp = arr[i];
    		while(temp!=0) {
    			int rem = temp%10;
    			rev = rev*10 + rem;
    			temp /= 10;
    		}
    		System.out.println(rev);
    		if(rev!=arr[i]) {
    			flag = true;
    			break;
    		}
    	}
    	
    	if(flag==true)
    		System.out.println(0);
    	else
    		System.out.println(1);
    }
    
}