/*
Reference: https://www.youtube.com/watch?v=jaQF6FSWYdE

Question:
Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false.
String C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

Example 1:

Input:
A = YX, B = X, C = XXY
Output: 0
Explanation: XXY is not interleaving
of YX and X
Example 2:

Input:
A = XY, B = X, C = XXY
Output: 1
Explanation: XXY is interleaving of
XY and X.
*/

import java.util.*;
public class InterleavedStrings {
	
	public static void main(String[] args) {
		String A = "YX";
		String B = "X";
		String C = "XXY";
		int n = A.length();
		int m = B.length();
		int len = C.length();
		
		int[][] dp = new int[n+1][m+1];
		for(int[] sub: dp) {
			Arrays.fill(sub, -1);
		}
		System.out.println(isInterleave(dp, A,B,C, n,m,len));
	}

	private static int isInterleave(int[][] dp, String A, String B, String C, int n, int m, int len) {
		// TODO Auto-generated method stub
		if(len==0) return 1;
		if(dp[n][m]!=-1) return dp[n][m];
		
		int a=0, b=0;
		if(n-1>=0 && A.charAt(n-1)==C.charAt(len-1)) {
			a = isInterleave(dp, A, B, C, n-1, m, len-1);
		}
		if(m-1>=0 && B.charAt(m-1)==C.charAt(len-1)) {
			b = isInterleave(dp, A, B, C, n, m-1, len-1);
		}
		
		return dp[n][m] = a==1 || b==1 ? 1 : 0;
		
	}
}

