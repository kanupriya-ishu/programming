/*
Question:
In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first one is complete (Sell->buy->sell->buy). Given stock prices throughout the day, find out the maximum profit that a share trader could have made.

Examples: 

Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12, 75 
Buy at 10, sell at 22, 
Buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.

Input:   price[] = {90, 80, 70, 60, 50}
Output:  0
Not possible to earn.
*/

import java.util.*;
public class MaxProfitTwice{

    public static void main(String[] args)
    {     
    	int[] arr = {0,7};
    	System.out.println(maxProfit(arr));
    }

	private static int maxProfit(int[] arr) {
		
		int n = arr.length;
		/*
		 * In dp[i] store how much will be the max profit if stock were bought 
		 * and sold on or before ith day
		 * */
		int[] dp = new int[n];
		int min = arr[0];
		
		for(int i=1; i<n; i++) {
			min = Math.min(min, arr[i]);
			int profit = arr[i]-min;
			dp[i] = Math.max(profit, dp[i-1]);
		}
		
		/*
		 * In dp2[i] store how much will be the max profit if stock were bought 
		 * and sold on or after ith day
		 * */
		int[] dp2 = new int[n];
		int max = arr[n-1];
		for(int i=n-2; i>=0; i--) {
			max = Math.max(max, arr[i]);
			int profit = max - arr[i];
			dp2[i] = Math.max(profit, dp2[i+1]);
		}
		
		/*
		 * The maximum profit will be max of dp[i] + dp2[i]
		 * */
		int max_profit = 0;
		for(int i=0; i<n; i++) {
			max_profit = Math.max(max_profit, dp[i]+dp2[i]);
		}
		
		return max_profit;
	}
}
