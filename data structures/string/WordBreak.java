/*
Question:
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details. 
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".
*/

import java.util.*;
public class WordBreak {
	
	private static Set<String> set = new HashSet<>();
	
    public static void main(String args[]) 
    {  
    	String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
    	
    	for(String i: temp_dictionary) {
    		set.add(i);
    	}
    	
    	System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
    	
    }

	private static boolean wordBreak(String str) {
		int n = str.length();
		if(n==0)
			return true;
		
		for(int i=0; i<=n; i++) {
			if(set.contains(str.substring(0, i)) && wordBreak(str.substring(i,n))) {
				return true;
			}
		}
		
		return false;
		
	}
    
}