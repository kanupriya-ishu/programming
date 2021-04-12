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
public class RabinKarpAlgo {
	public static final int d = 256;
	 public static void main(String args[]) 
	    {  
		 	String text = "GEEKS FOR GEEKS";
		    String pattern = "GEEK";
		         
		       // A prime number
		     int prime_no = 101; 
		     
		       // Function Call
		     search(pattern, text, prime_no);
	    	
	    }

	private static void search(String pattern, String text, int prime_no) {
		int m = pattern.length();
		int n = text.length();
		int p = 0; // hash value of pattern
		int t = 0; // hash value of text
		int h = 1;
		
		for(int i=0; i<m-1; i++) {
			h = (h*d)%prime_no;
		}
		
		// calculate hash value of pattern and first window of text
		for(int i=0; i<m; i++) {
			p = (d*p + pattern.charAt(i))%prime_no;
			t = (d*t + text.charAt(i))%prime_no;
		}
		int i,j;
		for(i=0; i<=n-m; i++) {
			if(p==t) {
				for(j=0; j<m; j++) {
					if(pattern.charAt(j)!=text.charAt(j+i))
						break;
				}
				
				if(j==m) {
					System.out.println("Pattern found at "+i);
				}
			}
			
			if(i<n-m) {
				t = (d*(t-text.charAt(i)*h) + text.charAt(i+m))%prime_no;
				if(t<0)
					t += prime_no;
			}
		}
	}
}