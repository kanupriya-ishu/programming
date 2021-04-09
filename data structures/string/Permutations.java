/*
Question:
Given a string S. The task is to print all permutations of a given string.

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.
*/

import java.util.*;
public class Permutations {
	
    public static void main(String args[]) 
    {  
    	String s = "abcd";
    	int n = s.length();
    	permute(s, 0, n-1);
    }

	private static void permute(String s, int l, int r) {
		
		if(l==r)
			System.out.println(s);
		for(int i=l; i<=r; i++) {
			s = swap(s, l, i); // find combinations
			permute(s, l+1, r); // recursion
			s = swap(s, l, i); // backtracking
		}
	}

	private static String swap(String s, int i, int j) {
		char temp;
		char[] arr = s.toCharArray();
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
}