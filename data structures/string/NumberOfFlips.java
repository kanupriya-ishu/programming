/*
Question:
Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.

Example 1:

Input:
S = "001"
Output: 1
Explanation: We can flip the 0th bit to 1
to have "101".

Example 2:

Input: 
S = "0001010111"
Output: 2
Explanation: We can flip the 1st and 8th bit
to have "0101010101".
*/
 
import java.util.*;

public class NumberOfFlips {

	static int NO_OF_CHARS = 256;

	public static void main(String args[]) {
		String s = "0001010111";
		
		int count1 = 0;
		for(int i=0; i<s.length(); i++) {
			if (i%2==0) {
				if(s.charAt(i)!='0')
					count1++;
			}
			else {
				if(s.charAt(i)!='1')
					count1++;
			}
		}
		
		int count2 = 0;
		for(int i=0; i<s.length(); i++) {
			if (i%2==0) {
				if(s.charAt(i)!='1')
					count2++;
			}
			else {
				if(s.charAt(i)!='0')
					count2++;
			}
		}
		
		System.out.println(count1<count2?count1:count2);

	}
}