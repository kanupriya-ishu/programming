/*
Question:
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.
Note: All occurrences of every character in ‘str1’ should map to the same character in ‘str2’

Example 1:

Input:
str1 = aab
str2 = xxy
Output: 1
Explanation: There are two different
charactersin aab and xxy, i.e a and b
with frequency 2and 1 respectively.

Example 2:

Input:
str1 = aab
str2 = xyz
Output:
Explanation: There are two different
charactersin aab but there are three
different charactersin xyz. So there
won't be one to one mapping between
str1 and str2.
*/

import java.util.*;

public class Isomorphic {
	
	private static int MAX_CHARS = 256;

	public static void main(String args[])
	{
		String s1 = "aab";
        String s2 = "xxy";
        
        System.out.println(isIsomorphic(s1, s2));
	}

	private static boolean isIsomorphic(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Boolean> map2 = new HashMap<>();
		
		for(int i=0; i<s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if(map1.containsKey(c1)) {
				if(map1.get(c1)!=c2) {
					return false;
				}
			}
			
			else {
				if(map2.containsKey(c2)) {
					return false;
				}
				else {
					map1.put(c1, c2);
					map2.put(c2, false);
				}
			}
		}
		
		return true;
	}
}