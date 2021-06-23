/*
Question:
Given the mobile numeric keypad. You can only press buttons that are up, left, right, or down to the current button. You are not allowed to press bottom row corner buttons (i.e. * and # ). Given a number N, the task is to find out the number of possible numbers of the given length.

Example 1:

Input: 1
Output: 10
Explanation: Number of possible numbers 
would be 10 (0, 1, 2, 3, …., 9)  

Example 2:
Input: N = 2
Output: 36
Explanation: Possible numbers: 00, 08, 11,
12, 14, 22, 21, 23, 25 and so on.
If we start with 0, valid numbers 
will be 00, 08 (count: 2)
If we start with 1, valid numbers 
will be 11, 12, 14 (count: 3)
If we start with 2, valid numbers 
will be 22, 21, 23,25 (count: 4)
If we start with 3, valid numbers 
will be 33, 32, 36 (count: 3)
If we start with 4, valid numbers 
will be 44,41,45,47 (count: 4)
If we start with 5, valid numbers 
will be 55,54,52,56,58 (count: 5) 
and so on.
*/

import java.util.*;
public class MobileNumericKeypadProblem {

	public static void main(String[] args) {
		int n = 2;
		System.out.println(count(n));
	}

	private static int count(int n) {
		// dp[i][j] stores the number of i digit numbers that can be formed at jth key
		int[][] dp= new int[n+1][10];
		
		// data[i] stores the numbers which can be pressed from ith key
		int[][] data = {
				{0, 8},
				{1, 2, 4},
				{2, 1, 3, 5},
				{3, 2, 6},
				{4, 1, 7, 5},
				{5, 4, 6, 2, 8},
				{6, 5, 3, 9},
				{7, 4, 8},
				{8, 7, 9, 5, 0},
				{9, 6, 8}
		};
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<10; j++) {
				// for 1 digit each key can be pressed once
				if(i==1) {
					dp[i][j] = 1;
				}
				else {
					// for ith digits the answer will be sum of possible keys of i-1th digits that can be pressed from that key
					for(int k: data[j]) {
						dp[i][j] += dp[i-1][k];
					}
				}
			}
		}
		
		// the sum of last row will be the answer
		int sum=0;
		for(int i=0; i<10; i++) {
			sum+= dp[n][i];
		}
		return sum;
	}

}
