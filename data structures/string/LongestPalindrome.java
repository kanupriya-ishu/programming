/*
Question:
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).

Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".


Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.
*/

import java.util.*;
public class LongestPalindrome {

    public static void main(String args[]) 
    {  
    	String s = "abc";
    	int max = 1;
    	int start = 0;
    	for(int i=0; i<s.length(); i++) {
    		for(int j=i; j<s.length(); j++) {
    			String sub = s.substring(i, j+1);
    			if(sub.equals(reverseString(sub))) {
    				if(sub.length()>max) {
    					start = i;
    					max = sub.length();
    				}
    			}
    		}
    	}
    	
    	System.out.println(max);
    	System.out.println(s.substring(start, start+max));
    }

    public static String reverseString(String s) {
    	char[] str = s.toCharArray();
    	int front = 0;
        int rear = s.length() - 1;
        
        while(front < rear)
        {
            swap(str, front, rear);
            front++;
            rear--;
        }
        
        String ans = "";
        
        for(int i=0; i<str.length; i++) {
        	ans += str[i];
        }
        
        return ans;
    }
    
    public static void swap(char[] s, int front, int rear)
    {
        char temp = s[front];
        s[front] = s[rear];
        s[rear] = temp;
    }    
}