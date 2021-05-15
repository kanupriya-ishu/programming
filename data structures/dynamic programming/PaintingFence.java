/*
Problem:
Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color.

Example 1:

Input:
N=3,  K=2 
Output: 6

Example 2:

Input:
N=2,  K=4
Output: 16
*/

import java.util.*;

public class PaintingFence {

	public static void main(String args[])
	{
		int s[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12};
        int x[] = {18, 7};
  
        System.out.println(carAssembleTime(s, t, e, x));
	}

	private static int carAssembleTime(int[][] s, int[][] t, int[] e, int[] x) {
		int s1 = e[0] + s[0][0]; // initial cost of line 1
		int s2 = e[1] + s[1][0]; // initial cost of line 2
		
		for(int j=1; j<s[0].length; j++) {
			// compare the (cost of line 1 + next spot of line 1) and (line 2 + time delay from line 1 + next spot of line 1)
			int temp_s1 = Math.min(s1 + s[0][j], s2 + t[1][j] + s[0][j]);
			// compare the (cost of line 2 + next spot of line 2) and (line 1 + time delay from line 2 + next spot of line 2)
			int temp_s2 = Math.min(s2 + s[1][j], s1 + t[0][j] + s[1][j]);
			s1 = temp_s1;
			s2 = temp_s2;
		}
		
		// add respective exit values
		s1 += x[0];
		s2 += x[1];
		
		return Math.min(s1, s2);
	}

}