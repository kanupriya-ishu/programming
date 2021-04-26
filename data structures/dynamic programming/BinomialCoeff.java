/*
Question:
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 

Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.
*/

import java.util.*;

public class BinomialCoeff {

	public static void main(String args[])
	{
		int n = 5;
		int r = 4;
		
		System.out.println(C(n, r));
	}

	private static int C(int n, int r) {
		int[][] C = new int[n+1][r+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(r, i); j++) {
				if(i==j || j==0) {
					C[i][j] = 1;
				}
				else {
					C[i][j] = C[i-1][j-1] + C[i-1][j];
				}
			}
		}
		
		return C[n][r];
	}

}