/*
Question:
You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.

Examples: 

Input  : []][][
Output : 2
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

Input  : [[][]]
Output : 0
The string is already balanced.
*/

import java.util.*;

public class MinBracketSwaps {

	public static void main(String args[])
	{
		String s = "[]][][";
	    System.out.println(swapCount(s));
	  
	    s = "[[][]]";
	    System.out.println(swapCount(s));
	}

	private static int swapCount(String s) {
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='[') {
				arr.add(i);
			}
		}
		
		int sum = 0;
		int p = 0;
		int count = 0;
		
		char[] ch = s.toCharArray();
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='[') {
				count++;
				p++;
			}
			
			else if(ch[i]==']') {
				count--;
			}
			
			if(count<0) {
				sum += arr.get(p) - i;
				char temp = ch[i];
				ch[i] = ch[arr.get(p)];
				ch[arr.get(p)] = temp;
				p++;
				
				count = 1;
			}
		}
		return sum;
	}


}