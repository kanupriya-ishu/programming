/*
Question:
Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated sequence of dictionary words. 


Example 1:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilike"
Output: 1
Explanation:The string can be segmented as "i like".

Example 2:

Input:
n = 12
B = { "i", "like", "sam", "sung", "samsung", "mobile",
"ice","cream", "icecream", "man", "go", "mango" }
A = "ilikesamsung"
Output: 1
Explanation: The string can be segmented as 
"i like samsung" or "i like sam sung".
 
*/

import java.util.*;

public class WordBreak {

	public static void main(String args[])
	{
		int n = 12;
		String[] dict = {"i", "like", "sam", "sung", "samsung", "mobile",
				"ice","cream", "icecream", "man", "go", "mango"};
		
		String sentence = "ilike";
		
		
		
		System.out.println(wordBreak(dict, n, sentence));
	}

	private static int wordBreak(String[] dict, int n, String sentence) {
		
		List<String> dictionary = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			dictionary.add(dict[i]);
		}
		
		// dp[i] stores the number of sentences that can be made from 
		// sentence starting at 0 index to ith index
		int[] dp = new int[sentence.length()];
		
		for(int i=0; i<sentence.length(); i++) {
			for(int j=0; j<=i; j++) {
				String word = sentence.substring(j, i+1);
				if(dictionary.contains(word)) {
					
					if(j>0) {
						dp[i] += dp[j-1];
					}
					else {
						dp[i] += 1;
					}
				}
			}
		}
		return dp[sentence.length()-1]>0 ? 1 : 0;
	}

}
