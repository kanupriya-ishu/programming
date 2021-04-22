/*
Question:
Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
Examples: 
 

Input  : str = "ABC"
Output : 2
We can make above string palindrome as "CBABC"
by adding 'B' and 'C' at front.

Input  : str = "AACECAAAA";
Output : 2
We can make above string palindrome as AAAACECAAAA
by adding two A's at front of string.
*/

import java.util.*;

public class MinCharsToAddToMakeStringPalindrome {

	public static void main(String args[])
	{
		String s = "AACECAAAA";
		System.out.println(getMin(s));	
	}
	
	public static int getMin(String s) {
		StringBuilder str = new StringBuilder();
		
		str.append(s);
		
		String rev = str.reverse().toString();
		str.reverse().append("$").append(rev);
		
		int[] lps = new int[str.length()];
		computeLPSarray(str.toString(), str.length(), lps);
		
		return s.length()-lps[str.length()-1];
	}

	private static void computeLPSarray(String pattern, int m, int[] lps) {
		int len = 0; // length of previous longest prefix suffix
		int i =1;
		
		lps[0] = 0;
		
		while(i<m) {
			if(pattern.charAt(i)==pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len!=0) {
					len = lps[len-1];
				}
				
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
}