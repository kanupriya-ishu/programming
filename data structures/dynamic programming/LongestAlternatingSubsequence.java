/*
Question:
A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the following relations :
x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
Your task is to find the longest such sequence.

Example 1:

Input: nums = {1,5,4}
Output: 3
Explanation: The entire sequenece is a 
alternating sequence.

Example 2:

Input: nums = {1,17,5,10,13,15,10,5,16,8}
Ooutput: 7
Explanation: There are several subsequences
that achieve this length. 
One is {1,17,10,13,10,16,8}.
*/

import java.util.*;
public class Test {

    public static void main(String[] args)
    {     
    	int[] arr = {1, 5, 4};
    	System.out.println(longestAlternatingSubsequence(arr));
    }

	private static int longestAlternatingSubsequence(int[] arr) {
		
		int inc=1, dec=1;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1]<arr[i]) {
				inc = dec + 1;
			}
			else if (arr[i] < arr[i - 1]){
				dec = inc + 1;
			}
		}
		
		return Math.max(inc, dec);
	}
}
