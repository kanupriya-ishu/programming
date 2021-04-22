/*
Question:
Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca”.

 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"

Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
*/

import java.util.*;

public class SmallestWindowOfAllCharactersOfSameString {

	public static void main(String args[])
	{
		String str = "aabcbcdbca";
        System.out.println("Smallest window containing all distinct"
                           + " characters is: " + findSubString(str));
	}

	private static String findSubString(String str) {
		
		int n = str.length();
		
		int distinct = 0;
		
		boolean[] visited = new boolean[MAX_CHARS];
		Arrays.fill(visited, false);
		
		for(int i=0; i<n; i++) {
			if(visited[str.charAt(i)]==false) {
				visited[str.charAt(i)]=true;
				distinct++;
			}
		}
		
		int start = 0, start_index = -1;
		int min_len = Integer.MAX_VALUE;
		
		int count = 0;
		int[] curr_count = new int[MAX_CHARS];
		
		for(int i=0; i<n; i++) {
			curr_count[str.charAt(i)]++;
			
			if(curr_count[str.charAt(i)]==1)
				count++;
			
			if(count==distinct) {
				
				while(curr_count[str.charAt(i)]>1) {
					if(curr_count[str.charAt(i)]>1) {
						curr_count[str.charAt(i)]--;
						start++;
					}
				}
				
				int len_window = i-start + 1;
				if(min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}
		
		return str.substring(start_index, start_index+min_len);
	}

}