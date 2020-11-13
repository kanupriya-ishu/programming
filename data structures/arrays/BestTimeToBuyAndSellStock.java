/*
	Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

	Note that you cannot sell a stock before you buy one.

	Example 1:

	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
				 Not 7-1 = 6, as selling price needs to be larger than buying price.
	Example 2:

	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

import java.util.*;
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		/* // brute force method
			int max = 0;
			
			for(int i=n-1; i>0; i--) {
				
				for(int j=0; j<i; j++) {
					int temp = arr[i] - arr[j];
					
					if (temp>max) {
						max = temp;
					}
				}
			}
		*/
		
		int min = arr[0];
		int max_profit = 0;
		int curr_profit = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			
			curr_profit = arr[i] - min;
			
			if(curr_profit>max_profit) {
				max_profit = curr_profit;
			}
		}
		
		System.out.println("Answer: "+max_profit);
	}

}
