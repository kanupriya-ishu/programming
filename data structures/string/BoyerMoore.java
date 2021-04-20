/*
Question:
Pattern searching is an important problem in computer science. When we do search for a string in a notepad/word file, browser, or database, pattern searching algorithms are used to show the search results. A typical problem statement would be- 
Given a text txt[0..n-1] and a pattern pat[0..m-1] where n is the length of the text and m is the length of the pattern, write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m. 
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
public class BoyerMoore {
	
	static int NO_OF_CHARS = 256;
	
	// 8 directions
	static int[] x = {0,0,-1,1,1,-1,1,-1};
	static int[] y = {-1,1,0,0,1,-1,-1,1};
	
	public static void main(String args[])
	{
		char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);

	}

	private static void search(char[] txt, char[] pat) {
		int m = pat.length;
		int n = txt.length;
		
		int badchar[] = new int[NO_OF_CHARS];
		
		badCharHeuristic(pat, m, badchar);
		
		int s = 0; // shifts
		
		while(s<=n-m) {
			int j = m-1;
			
			while(j>=0 && pat[j]==txt[s+j]) {
				j--;
			}
			
			if(j<0) {
				System.out.println("Patterns occur at shift = "+s);
				s += (s+m < n)? m-badchar[txt[s+m]] : 1;
			}
			
			else {
				 s += Math.max(1, j - badchar[txt[s+j]]);
			}
		}
		
	}

	private static void badCharHeuristic(char[] pat, int m, int[] badchar) {
		for(int i=0; i<NO_OF_CHARS; i++) {
			badchar[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			badchar[(int)pat[i]] = i;
		}
	}
}