/*
Question:
Find total number of possible Binary Search Trees with n different keys
*/

import java.util.*;
public class NoOfBST {

    public static void main(String[] args)
    {     
    	int n = 3;
    	System.out.println(noOfBST(n));
    }

	private static int noOfBST(int n) {
		/*
		 * Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)
		 * For n = 0, 1, 2, 3, … values of Catalan numbers are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …. So are numbers of Binary Search Trees.
		 * Total number of possible Binary Trees with n different keys (countBT(n)) = countBST(n) * n! 
		 * */
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int l = 0;
			int r = i-1;
			while(l<=i-1) {
				dp[i] += dp[l]*dp[r];
				l++;
				r--;
			}
		}
		
		return dp[n];
	}

}
