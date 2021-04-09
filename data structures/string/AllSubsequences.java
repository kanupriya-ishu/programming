/*
Question:
Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.
Examples: 

Input : abc
Output : a, b, c, ab, bc, ac, abc

Input : aaa
Output : a, aa, aaa

Refrence: https://www.youtube.com/watch?v=KCEPvdLqlYI
*/

import java.util.*;
public class AllSubsequences {
	
	static List<String> l = new ArrayList<>();
	
    public static void main(String args[]) 
    {  
    	String s = "abcd";
    	findSubSequence(s, "");
    	System.out.println(l);
    }

	public static void findSubSequence(String s1, String s2) {
		
		if(s1.length()==0) {
			l.add(s2);
			return;
		}
		
		findSubSequence(s1.substring(1), s2+s1.charAt(0));
		
		findSubSequence(s1.substring(1), s2); 
	} 
}