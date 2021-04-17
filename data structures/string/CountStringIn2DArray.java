/*
Question:
Given a 2-Dimensional character array and a string, we need to find the given string in 2-dimensional character array such that individual characters can be present left to right, right to left, top to down or down to top.

Examples: 

Input : a ={
            {D,D,D,G,D,D},
            {B,B,D,E,B,S},
            {B,S,K,E,B,K},
            {D,D,D,D,D,E},
            {D,D,D,D,D,E},
            {D,D,D,D,D,G}
           }
        str= "GEEKS"
Output :2

Input : a = {
            {B,B,M,B,B,B},
            {C,B,A,B,B,B},
            {I,B,G,B,B,B},
            {G,B,I,B,B,B},
            {A,B,C,B,B,B},
            {M,C,I,G,A,M}
            }
        str= "MAGIC"

Output :4
*/

import java.util.*;
public class Test {
	
	public static void main(String args[])
	{
		 String s = "GEEKS";
		 char arr[][] = {{'D','D','D','G','D','D'},
				 		 {'B','B','D','E','B','S'},
		 				 {'B','S','K','E','B','K'},
		 				 {'D','D','D','D','D','E'},
		 				 {'D','D','D','D','D','E'},
		 				 {'D','D','D','D','D','G'}};
		 
		 int ans = 0;
		 int size = s.length();
		 
		 for(int i=0; i<arr.length; i++) {
			 for(int j=0; j<arr[0].length; j++) {
				 ans += solve(i, j, s, arr, size, 0);
			 }
		 }
		 
		 System.out.println(ans);
	}

	private static int solve(int i, int j, String s, char[][] arr, int size, int k) {
		int found = 0;
		if(i>=0 && j>=0 && i<arr.length && j<arr[0].length && s.charAt(k)==arr[i][j]) {
			char temp = s.charAt(k);
			arr[i][j] = 0;
			k++;
			if(k==size) {
				found = 1;
			}
			else {
				found += solve(i+1, j, s, arr, size, k);
				found += solve(i-1, j, s, arr, size, k);
				found += solve(i, j+1, s, arr, size, k);
				found += solve(i, j-1, s, arr, size, k);
			}
			arr[i][j] = temp;
		}
		
		return found;
	}
}