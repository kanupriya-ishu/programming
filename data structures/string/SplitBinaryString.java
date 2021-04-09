/*
Question:
Given a binary string str of length N, the task is to find the maximum count of substrings str can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.

Example:

Input: str = “0100110101”
Output: 4
The required substrings are “01”, “0011”, “01” and “01”.

Input: str = “0111100010”
Output: 3
*/

import java.util.*;
public class SplitBinaryString {
	
    public static void main(String args[]) 
    {  
    	String s = "0100110101";
    	System.out.println(countBinaryString(s));
    }


	private static int countBinaryString(String s) {
		int n = s.length();
		int count0 = 0, count1 = 0, cnt = 0;
		
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='0')
				count0++;
			else
				count1++;
			
			if(count0 == count1)
				cnt++;
		}
		
		if(count0 != count1)
			return -1;
		
		return cnt;
	}
}