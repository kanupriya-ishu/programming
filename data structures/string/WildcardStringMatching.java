/*
Question:
Given two strings wild and pattern where wild string may contain wild card characters and pattern string is a normal string. Determine if the two strings match. The following are the allowed wild card characters in first string :-

* --> Matches with 0 or more instances of any 
character or set of characters.
? --> Matches with any one character.

Example 1:

Input: wild = ge*ks
       pattern = geeks
Output: Yes
Explanation: Replace the '*' with 'e' to obtain 
the string.

Example 2:

Input: wild = ge?ks*
       pattern = geeksforgeeks
Output: Yes
Explanation: Replace '?' with 'e' and '*' with
'forgeeks' and it will be same as pattern.
*/

import java.util.*;

public class WildcardStringMatching {

	public static void main(String args[])
	{
		String first = "ge?ks*";
		String second = "geeksforgeeks";
		
		System.out.println(match(first, second));
	}

	private static boolean match(String first, String second) {
		
		if(first.length()==0 && second.length()==0)
			return true;
		
		if(first.length()>1 && first.charAt(0)=='*' && second.length()==0)
			return false;
		
		if((first.length()>1 && first.charAt(0)=='?') || 
		   (first.length()!=0 && second.length()!=0 && first.charAt(0)==second.charAt(0))) {
			return match(first.substring(1), second.substring(1));
		}
		
		if(first.length()>0 && first.charAt(0)=='*') {
			return match(first.substring(1), second) || match(first, second.substring(1));
		}
		return false;
	}

}