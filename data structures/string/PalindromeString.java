/*
Question:
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
*/

public class PalindromeString {

    public static void main(String args[]) 
    {  
    	String s = "abba";
    	
        if(s.equals(reverseString(s))) {
        	System.out.println("Palindrome");
        }
        
        else {
        	System.out.println("Not Palindrome");
        }
        
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