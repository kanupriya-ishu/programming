/*
Question:
Find how many palindromic subsequences (need not necessarily be distinct) can be formed in a given string. Note that the empty string is not considered as a palindrome. 
Examples: 

Input : str = "abcd"
Output : 4
Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d" 

Input : str = "aab"
Output : 4
Explanation :- palindromic subsequence are :"a", "a", "b", "aa"

Input : str = "aaaa"
Output : 15
*/

import java.util.*;
public class CountPalindromicSubsequence {
static List<String> l = new ArrayList<>();
	
    public static void main(String args[]) 
    {  
    	String s = "aaaa";
    	int count = 0;
    	findSubSequence(s, "");
    	for(String i:l) {
    		if(i.equals(reverseString(i))) {
    			count++;
    		}
    	}
    	System.out.println(count-1);
    }

	public static void findSubSequence(String s1, String s2) {
		
		if(s1.length()==0) {
			l.add(s2);
			return;
		}
		
		findSubSequence(s1.substring(1), s2+s1.charAt(0));
		
		findSubSequence(s1.substring(1), s2); 
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