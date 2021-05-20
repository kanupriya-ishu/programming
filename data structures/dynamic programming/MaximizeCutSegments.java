/*
Question:
Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. 
Here x, y, and z are integers. After performing all the cut operations, your total number of cut segments must be maximum.

Example 1:

Input:
N = 4
x = 2, y = 1, z = 1
Output: 4
Explanation:Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.

Example 2:

Input:
N = 5
x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
*/

import java.util.*;

public class MaximizeCutSegments {

	public static void main(String args[])
	{
		int l = 100;
		int x = 15, y = 23, z = 50;
		System.out.println(maximumCuts(l, x, y, z));
	}

	private static int maximumCuts(int l, int x, int y, int z) {
		int[] dp = new int[l+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for(int i=0; i<dp.length; i++) {
			if (dp[i] == -1)
                continue;
			
			if(i+x<=l) {
				dp[i+x] = Math.max(dp[i+x], dp[i]+1);
			}
			
			if(i+y<=l) {
				dp[i+y] = Math.max(dp[i+y], dp[i]+1);
			}
			
			if(i+z<=l) {
				dp[i+z] = Math.max(dp[i+z], dp[i]+1);
			}
		}
		
		if (dp[l]==-1)
		    return 0;
		
		return dp[l];
	}

}