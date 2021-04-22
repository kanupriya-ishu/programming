/*
Question:
Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Examples:

Input: aaabc 
Output: abaca 

Input: aaabb
Output: ababa 

Input: aa 
Output: Not Possible

Input: aaaabc 
Output: Not Possible
*/

import java.util.*;

public class ReorganizeString {
	
	static final int MAX_CHARS =  256;

	public static void main(String args[])
	{
		String s = "aaabc";
		System.out.println(reorganizeString(s));	
	}

	private static String reorganizeString(String s) {
		Map<Character,Integer> counts = new HashMap<>();
		for(char c: s.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b)-counts.get(a));
		maxHeap.addAll(counts.keySet());
		
		StringBuilder result = new StringBuilder();
		while(maxHeap.size() > 1) {
			char current = maxHeap.remove();
			char next = maxHeap.remove();
			result.append(current);
			result.append(next);
			counts.put(current, counts.get(current)-1);
			counts.put(next, counts.get(next)-1);
			if(counts.get(current)>0) {
				maxHeap.add(current);
			}
			
			if(counts.get(next)>0) {
				maxHeap.add(next);
			}
		}
		
		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (counts.get(last)>1) {
				return "";
			}
			result.append(last);
		}
		
		return result.toString();
	}
}