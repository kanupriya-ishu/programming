/*
Question:
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 

Example 1:

Input:
N = 5
P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
Output: 3
Explanation: The given pairs are { {5, 24}, {39, 60},
{15, 28}, {27, 40}, {50, 90} },the longest chain that
can be formed is of length 3, and the chain is
{{5, 24}, {27, 40}, {50, 90}}

Example 2:

Input:
N = 2
P[] = {5 10 , 1 11}
Output: 1
Explanation:The max length chain possible is only of
length one.
*/

import java.util.*;
public class MaximumLengthOfPairChain {

	public static void main(String[] args) {
		Pair arr[] = new Pair[]{
		  new Pair(5,24),
		  new Pair(15, 25),                     
		  new Pair (27, 40),
		  new Pair(50, 60)};
		System.out.println(maxChainLength(arr, arr.length));
	}

	private static int maxChainLength(Pair[] arr, int length) {
		
		// sort array based on first element
		Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.a - p2.a;
            }
        });
		
		int n = arr.length;
		int[] dp = new int[n];
		int max = Integer.MIN_VALUE;
		
		// fill array with 1
		Arrays.fill(dp, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				// if first element of arr[i] is greater than second element of arr[j]
				// and length of pair chain of j => dp[j] + 1 is greater than current length dp[i]
				// then store that value in dp[i]
				if(arr[i].a > arr[j].b && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
				
				// keep a track of max length of chain
				max = Math.max(max, dp[i]);
			}
		}
		
		return max;
	}
}



class Pair
{
    int a;
    int b;
     
    public Pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
