/*
Question:
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

Examples:

Input:  txt[] = "THIS IS A TEST TEXT"
        pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA"
        pat[] =  "AABA"
Output: Pattern found at index 0
        Pattern found at index 9
        Pattern found at index 12
*/

import java.util.*;
public class KMP {
	
	public static void main(String args[])
	{
	    String text = "AABAACAADAABAABA";
	    String pattern = "AABA";
	    KMPSearch(pattern, text);
	}

	private static void KMPSearch(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		
		int lps[] = new int[m];
		int j = 0; //index for pattern
		
		computeLPSarray(pattern, m, lps);
		
		int i=0; // index for text
		while(i<n) {
			
			if(pattern.charAt(j)==text.charAt(i)) { // increment i and j till a mismatch is found
				j++;
				i++;
			}
			
			if(j==m) {
				System.out.println("Pattern found at "+(i-j));
				j = lps[j-1];
			}
			
			// mismatch after j matches
			else if(i<n && pattern.charAt(j)!=text.charAt(i)) {
				if(j!=0) {
					j = lps[j-1];
				}
				
				else {
					i++;
				}
			}
		}
	}

	private static void computeLPSarray(String pattern, int m, int[] lps) {
		int len = 0; // length of previous longest prefix suffix
		int i =1;
		
		lps[0] = 0;
		
		while(i<m) {
			if(pattern.charAt(i)==pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len!=0) {
					len = lps[len-1];
				}
				
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

}