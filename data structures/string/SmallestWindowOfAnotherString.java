/*
Question:
Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently. 
Examples: 



Input: string = "this is a test string", pattern = "tist" 
Output: Minimum window is "t stri" 
Explanation: "t stri" contains all the characters of pattern.
Input: string = "geeksforgeeks", pattern = "ork" 
Output: Minimum window is "ksfor"
*/

import java.util.*;

public class SmallestWindowOfAnotherString {
	
	static final int MAX_CHARS =  256;

	public static void main(String args[])
	{
		String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :"
                         + findSubString(str, pat));	
	}

	private static String findSubString(String str, String pat) {
		
		int n1 = str.length();
		int n2 = pat.length();
		
		if(n1<n2) {
			return "";
		}
		
		int hash_pat[] = new int[MAX_CHARS];
        int hash_str[] = new int[MAX_CHARS];
        
        for(int i=0; i<n2; i++) {
        	hash_pat[pat.charAt(i)]++;
        }
        
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        
        int count = 0;
        
        for(int i=0; i<n1; i++) {
        	hash_str[str.charAt(i)]++;
        	
        	if(hash_str[str.charAt(i)]<=hash_pat[str.charAt(i)])
        		count++;
        	
        	if(count==n2) {
        		
        		while(hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)]==0) {
        			if(hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
        				hash_str[str.charAt(start)]--;
        			}
        			start++;
        		}
        		
        		int len = i - start + 1;
        		if(min_len > len) {
        			min_len = len;
        			start_index = start;
        		}
        	}
        	      	
        }
        
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        
        }
        
        return str.substring(start_index, start_index + min_len);
	}
}