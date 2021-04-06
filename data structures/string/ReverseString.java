/*
Question:
Write a function that reverses a string. The input string is given as an array of characters s.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

import java.util.*;
public class Test {

    public static void main(String args[]) 
    {  
    	String s = "hello world";
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
        System.out.println(ans);
        
    }
    
    public static void swap(char[] s, int front, int rear)
    {
        char temp = s[front];
        s[front] = s[rear];
        s[rear] = temp;
    }
}