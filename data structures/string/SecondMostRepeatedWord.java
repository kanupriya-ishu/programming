/*
Question:
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.
*/

import java.util.*;

public class SecondMostRepeatedWord {

	public static void main(String args[]) {
		String arr[] = { "ccc", "aaa", "ccc","ddd", "aaa", "aaa" };
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
			
			else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		String max_string = "";
		String second_string = "";
		
		int max = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		
		for(Map.Entry i : map.entrySet()) {
			String key = (String)i.getKey();
			int value = (int)i.getValue();
			
			if(value>max) {
				max = value;
				max_string = key;
			}
		}
		
		for(Map.Entry i : map.entrySet()) {
			String key = (String)i.getKey();
			int value = (int)i.getValue();
			
			if(value>second && value!=max) {
				second = value;
				second_string = key;
			}
		}
		
		System.out.println(second_string);		
	}
}