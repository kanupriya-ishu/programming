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

public class MaximumProfit {

    public static void main(String args[]) 
    {  
    	int[] arr = {2, 30, 15, 10, 8, 25, 80};
    	
    	int n = arr.length;
    	
    	int[] profit = new int[n]; // in java, array is initialised with value 0
    	
    	// profit if only one transaction occurs
    	// starting from the end index to the first index, subtract the current value with the max_value
    	int max = arr[n-1];
    	
    	for(int i=n-2; i>=0; i--) {
    		if(arr[i]>max)
    			max=arr[i];
    		
    		profit[i] = Math.max(profit[i+1], max - arr[i]);
    	}
    	
    	// profit if two transactions occur
    	// start from first index to last, answer = profit if one transaction occur + (current value - minimum value)
    	// final answer will be stored in profit[n-1]
    	int min = arr[0];
    	
    	for(int i=1; i<n; i++) {
    		if(arr[i]<min)
    			min = arr[i];
    		
    		profit[i] = Math.max(profit[i-1], profit[i]+arr[i]-min);
    	}
    	
    	System.out.println("Answer: " + profit[n-1]);
    }
    
}