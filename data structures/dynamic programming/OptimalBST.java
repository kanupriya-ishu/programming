/*
Question:
Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches for keys[i]. 
Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
*/

import java.util.*;
public class OptimalBST {

    public static void main(String[] args)
    {     
    	int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
    	System.out.println(optimalBST(keys, freq));
    }

	private static int optimalBST(int[] keys, int[] freq) {
		
		int[][] dp = new int[keys.length][keys.length];
		
		for(int g=0; g<keys.length; g++) {
			for(int i=0, j=g; j<keys.length; i++, j++) {
				// if only one key is there then frequency of that key will be stored
				if(g==0) {
					dp[i][j] = freq[i];
				}
				
				// if two keys are there then val1 will be (freq[key1] + 2*freq[key2]) => 
				// key1 is root node so 1 time only it will be searched but key2 is child node 
				// so we have down so the cost will be 2 hence frequency will be multiplied by 2
				// similarly val2 will be (freq[key2] + 2*freq[key1]) =? here key2 is root node
				// min of val1 and val2 will be stored
				else if(g==1) {
					int val1 = freq[i] + 2*freq[j];
					int val2 = freq[j] + 2*freq[i];
					dp[i][j] = Math.min(val1, val2);
				}
				
				// otherwise
				// we will traverse from node i to j and find out the possibilities considering each key as root node
				// and then finding out the minimum of all the possibilities
				else {
					int min = Integer.MAX_VALUE;
					int sum = 0;
					
					// sum of frequencies of node from i to j will be added to answer because at each level 
					// the cost will increase by frequency as we will have to search deep
					for(int k=i; k<=j; k++) {
						sum += freq[k];
					}
					
					// here we consider kth key is the root node
					// then we find the left subtree : i to k-1
					// and the right subtree: k+1 to j
					// then we find the sum of all the three values and find the min
					
					for(int k=i; k<=j; k++) {
						int left = k==i? 0 : dp[i][k-1];
						int right = k==j? 0 : dp[k+1][j];
						
						min = Math.min(min, left+right+sum);
					}
					
					dp[i][j] = min;
				}
			}
		}
		
		return dp[0][keys.length-1];
	}

}
