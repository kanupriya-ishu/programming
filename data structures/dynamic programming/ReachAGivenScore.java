/*
Question:
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow.The first line of each test case is n.

Output:
For each testcase, in a new line, print number of ways/combinations to reach the given score.

Constraints:
1 ≤ T ≤ 100
1 ≤ n ≤ 1000

Example:
Input
3
8
20
13
Output
1
4
2
Explanation
For 1st example when n = 8
{ 3, 5 } and {5, 3} are the two possible permutations but these represent the same cobmination. Hence output is 1.
*/

import java.util.*;

public class ReachAGivenScore {

	public static void main(String args[])
	{
		int[] points = {3, 5, 10};
		int n = points.length;
		int totalScore = 20;
		System.out.println(numberOfCombinations(points, n, totalScore));
	}

	private static int numberOfCombinations(int[] points, int n, int totalScore) {
		
		// this question is similar to coin change problem
		int[] dp = new int[totalScore+1];
		dp[0] = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=points[i]; j<=totalScore; j++) {
				dp[j] += dp[j-points[i]];
			}
		}
		
		return dp[totalScore];
	}

}
