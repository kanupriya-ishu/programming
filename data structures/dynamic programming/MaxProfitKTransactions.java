/*
Reference: https://www.youtube.com/watch?v=3YILP-PdEJA

Question:
In the stock market, a person buys a stock and sells it on some future date. Given the stock prices of N days in an array A[ ] and a positive integer K, find out the maximum profit a person can make in at-most K transactions. A transaction is equivalent to (buying + selling) of a stock and new transaction can start only when the previous transaction has been completed.


Example 1:

Input: K = 2, N = 6
A = {10, 22, 5, 75, 65, 80}
Output: 87
Explaination: 
1st transaction: buy at 10 and sell at 22. 
2nd transaction : buy at 5 and sell at 80.
Example 2:

Input: K = 3, N = 4
A = {20, 580, 420, 900}
Output: 1040
Explaination: The trader can make at most 2 
transactions and giving him a profit of 1040.
Example 3:

Input: K = 1, N = 5
A = {100, 90, 80, 50, 25}
Output: 0
Explaination: Selling price is decreasing 
daily. So seller cannot have profit.
*/

package solution;
import java.util.*;
public class MaxProfitKTransactions {

	public static void main(String[] args) {
		int k = 2;
        int[] price = { 10, 22, 5, 75, 65, 80 };
        int n = price.length;
		System.out.println(maxProfit(price, n, k));
	}

	private static int maxProfit(int[] price, int n, int k) {
		int[][] dp = new int[k+1][n];
		
		/*
		 * Suppose there are 6 days and 3 transactions => n = 6, k = 3
		 * Assume we have to find maximum profit on 5th day with maximum 3 transactions => dp[3][4] (4 because it 0 indexed array)
		 * dp[3][4] will be max of (transaction done on previous day at most 3 transactions => dp[3][3] and (
		 * max of transactions done with at most 2 transactions + current transaction => price[j]-price[k] + dp[2][k] where k is iterating from 0 to j))
		 * price[j]-price[k] + dp[2][3] can also be written as dp[2][k]-price[k] + price[j]
		 * You can see price[j] is constant 
		 * So to avoid 3rd loop we can keep a track of max of (dp[2][k] - price[k]) and we can add price[j] to that max, let's call this value x
		 * then we can find max of x and dp[3][3] and store that value in dp[3][4]
		 * */
		
		for(int i=1; i<=k; i++) {
			int max = Integer.MIN_VALUE;
			for(int j=1; j<n; j++) {
				if(dp[i-1][j-1] - price[j-1]>max) {
					max = dp[i-1][j-1] - price[j-1];
				}
				dp[i][j] = Math.max(max + price[j], dp[i][j-1]);
			}
		}
		
		return dp[k][n-1];
	}

}
