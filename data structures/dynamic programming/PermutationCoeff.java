/*
Question:
The Permutation Coefficient represented by P(n, k) is used to represent the number of ways to obtain an ordered subset having k elements from a set of n elements.

Examples : 

P(10, 2) = 90
P(10, 3) = 720
P(10, 0) = 1
P(10, 1) = 10
*/

import java.util.*;

public class PermutationCoeff {

	public static void main(String args[])
	{
		int n = 10;
		int r = 2;
		
		System.out.println(P(n, r));
	}

	private static int P(int n, int r) {
		int[][] P = new int[n+1][r+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(r, i); j++) {
				if(j==0) {
					P[i][j] = 1;
				}
				else {
					P[i][j] = P[i-1][j] + j*P[i-1][j-1];
				}
			}
		}
		
		return P[n][r];
	}

}