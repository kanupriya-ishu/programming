/*
Question:
Given N friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.


Example 1:

Input:N = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.

Example 2: 

Input: N = 2
Output: 2
Explanation:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countFriendsPairings() which accepts an integer n and return number of ways in which friends can remain single or can be paired up.

*/

import java.util.*;

public class FriendsPairingProblem {

	public static void main(String args[])
	{
		int n = 5;
		System.out.println(calculateWays(n));
	}

	private static int calculateWays(int n) {
		if (n<=2) {
			return n;
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = 1; // one number can be paired in only one way i.e. when it stays single
		dp[2] = 2; // two numbers can be paired in two ways one: both numbers stay single, two: they pair up
		
		for(int i=3; i<=n; i++) {
			// f(n) = f(n-1) + (n-1) * f(n-2)
			// when you consider number from 1 to n, they can be paired in following way
			// first: 1 stays single and n-1 numbers recurse = f(n-1)
			// second: 1 pairs up with either of the other n-1 numbers, n-1 such pairs are possible: 1-2, 1-3...1-n
			// and then n-2 numbers will remain and they will recurse = (n-1)*f(n-2)
			dp[i] = dp[i-1] + (i-1)*dp[i-2];
		}
		
		return dp[n];
	}
}