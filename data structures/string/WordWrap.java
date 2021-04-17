/*
Question:
Given an array of size n, which denotes the number of characters in one word and number of characters a line can have. The task is simple, count the number of words in a single line with space character between two words.
 

Example 1:

Input: nums = {3,2,2,5}, k = 6
Output: {{1,1},{2,3},{4,4}}
Explanation: Given a line can have 6
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4

Example 2:

Input: nums = {3,2,2}, k = 4
Output: {{1,1},{2,2},{3,3}}
Explanation: Given a line can have 4 
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4
*/

import java.util.*;
public class WordWrap {
	
	public static void main(String args[])
	{
		 int[] nums = {3,2,2,5};
		 int k = 6;
		 
		 // Solved using Greedy method
		 int line = 1;
		 for(int i=0; i<nums.length; i++) {
			 int sum = 0;
			 sum = sum + nums[i];
			 System.out.println("Line "+line + ": "+i);
			 for(int j = i; sum<=k && j<nums.length; j++) {
				 sum = sum + nums[j] + 1;
				 if(sum<=k) {
					 i++;
					 System.out.println("Line "+line + ": "+i);
				 }
			 }
			 line++;
		 }
	}
}