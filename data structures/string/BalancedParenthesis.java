/*
Question:
Given an expression string exp, write a program to examine whether the pairs and the orders of "{", "}", "(", ")", "[", "]" are correct in exp.

Example: 

Input: exp = "[()]{}{[()()]()}" 
Output: Balanced

Input: exp = "[(])" 
Output: Not Balanced 

*/

import java.util.*;
public class BalancedParenthesis {
	static final int MAX = 100;
	static char[] s = new char[MAX];	
	static int top;
	
	BalancedParanthesis() {
		top = -1;
	}
	
	static void push(char s[], char x)
	{
		if (top>MAX-1)
		{
			System.out.println("STACK OVERFLOW!");
		}
		
		else
			s[++top] =  x;
	}
	
	static char pop(char s[])
	{
		char x;
		if(top<0)
		{
			System.out.println("STACK UNDERFLOW!");
		}
		else
		{
			x = s[top--];
			return x;
			
		}
		
		return 'x';
	}
	
	boolean isEmpty() 
    { 
        return (top < 0); 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:");
		String str = sc.nextLine();
		sc.close();
		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(c=='(' || c=='{' || c=='[')
			{
				push(s, c);
			}
			else if(c==')')
			{
				if(s[top]=='(')
				{
					char x = pop(s);
					System.out.println(x+" is popped");
				}
				else
				{
					System.out.println("UNBALANCED");
					break;
				}
			}
			else if(c==']')
			{
				if(s[top]=='[')
				{
					char x = pop(s);
					System.out.println(x+" is popped");
				}
				else
				{
					System.out.println("UNBALANCED");
					break;
				}
			}
			else if(c=='}')
			{
				if(s[top]=='{')
				{
					char x = pop(s);
					System.out.println(x+" is popped");
				}
				else
				{
					System.out.println("UNBALANCED");
					break;
				}
			}
			
		}
		
		if(top==0)
		{
			System.out.println("BALANCED");
		}
		else {
			System.out.println("UNBALANCED");
		}
	}

}
