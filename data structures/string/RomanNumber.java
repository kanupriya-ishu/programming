/*
Question:
Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Example 1:

Input:
s = V
Output: 5

Example 2:

Input:
s = III 
Output: 3
*/

import java.util.*;
public class RomanNumber {
	
	static int NO_OF_CHARS = 256;
	
	// 8 directions
	static int[] x = {0,0,-1,1,1,-1,1,-1};
	static int[] y = {-1,1,0,0,1,-1,-1,1};
	
	public static void main(String args[])
	{
		  String str = "MCMIV";
		  int sum = 0;
		  
		  for(int i=0; i<str.length(); i++) {
			int s1 = value(str.charAt(i));
			
			if(i+1 < str.length()) {
				int s2 = value(str.charAt(i+1));
				 if(s1>=s2) {
					 sum += s1;
				 }
				 
				 else {
					 sum += s2 - s1;
					 i++;
				 }
			}
			
			else {
				sum += s1;
			}
		  }
		  
		  System.out.println(sum); 
	}

	private static int value(char ch) {
		switch(ch) {
			case 'I':
				return 1;
			
			case 'V':
				return 5;
			
			case 'X':
				return 10;
				
			case 'L':
				return 50;
				
			case 'C':
				return 100;
				
			case 'D':
				return 500;
				
			case 'M':
				return 1000;
		}
		return -1;
	}
}