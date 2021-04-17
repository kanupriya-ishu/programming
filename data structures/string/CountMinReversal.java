/*
Question:
Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. Find minimum number of bracket reversals to make the expression balanced.
Examples: 

Input:  exp = "}{"
Output: 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced, 
the balanced expression is '{}'

Input:  exp = "{{{"
Output: Can't be made balanced using reversals

Input:  exp = "{{{{"
Output: 2 

Input:  exp = "{{{{}}"
Output: 1 

Input:  exp = "}{{}}{{{"
Output: 3
*/

import java.util.*;
public class CountMinReversal {
	
	public static void main(String args[])
	{
		 String s = "}}{{";
		 System.out.println(countMinReversal(s));
	}

	private static int countMinReversal(String s) {
		
		int n = s.length();
		
		if(n%2!=0) {
			return -1;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			char ch = s.charAt(i);
			
			if(ch=='}' && !stack.isEmpty()) {
				if(stack.peek()!='{') {
					stack.push(ch);
				}
				
				else{
					stack.pop();
				}
			}
			
			else {
				stack.push(ch);
			}
		}
		
		int len = stack.size();
		
		int left = 0, right = 0;
		while(!stack.isEmpty()) {
			if(stack.peek()=='{') {
				left++;
				stack.pop();
			}
			
			else {
				right++;
				stack.pop();
			}
		}
		
		return (int)(Math.ceil((double)left/2)+Math.ceil((double)right/2)) ;
	}
}