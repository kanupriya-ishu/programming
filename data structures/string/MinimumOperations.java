/*
Question:
Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.

Examples: 

Input:  A = "ABD", B = "BAD"
Output: 1
Explanation: Pick B and insert it at front.

Input:  A = "EACBD", B = "EABCD"
Output: 3
Explanation: Pick B and insert at front, EACBD => BEACD
             Pick A and insert at front, BEACD => ABECD
             Pick E and insert at front, ABECD => EABCD
*/

import java.util.*;

public class MinimumOperations {
	
	private static int MAX_CHARS = 256;

	public static void main(String args[])
	{
		String A = "EACBD";
        String B = "EABCD";
         
        System.out.println("Minimum number of operations required is " + minOps(A, B));
	}

	private static int  minOps(String a, String b) {
		int n1 = a.length();
		int n2 = b.length();
		
		if(n1!=n2) {
			return -1;
		}
		
		int[] count = new int[MAX_CHARS];
		
		for(int i=0; i<n1; i++) {
			count[a.charAt(i)]++;
			count[b.charAt(i)]--;
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i]!=0) {
				return -1;
			}
		}
		
		int res = 0;
		
		int i = n1-1, j = n2-1;
		
		while(i>=0) {
			if(a.charAt(i)!=b.charAt(j)) {
				res++;
			}
			else {
				j--;
			}
			i--;
		}
		
		return res;
	}

}