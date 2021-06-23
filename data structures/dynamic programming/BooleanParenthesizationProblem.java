/*
Question:

Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

 

Example 1:

Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates 
to true in 4 ways ((T|T)&(F^T)), 
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).

Example 2:

Input: N = 5
S = T^F|F
Output: 2
Explaination: ((T^F)|F) and (T^(F|F)) are the 
only ways.
*/

import java.util.*;
public class BooleanParenthesizationProblem {

	public static void main(String[] args) {
		int n = 5;
		String s = "T^F|F";
		System.out.println(countWays(n, s));
	}

	private static int countWays(int len, String s) {
		
		// s1 string contains T and F
		String s1 = "";
		// s2 string contains the operators
		String s2 = "";
		
		for(int i=0; i<len; i++) {
			if(s.charAt(i)=='&' || s.charAt(i)=='|' || s.charAt(i)=='^') {
				s2 += s.charAt(i);
			}
			else {
				s1 += s.charAt(i);
			}
		}
		
		System.out.println(s1);
		System.out.println(s2);
		
		int n = s1.length();
		
		// dpt[i][j] denotes the number of ways the expression(s2) 
		// starting at i and ending at j will give true
		int[][] dpt = new int[n][n];
		// dpf[i][j] denotes the number of ways the expression(s2) 
		// starting at i and ending at j will give false
		int[][] dpf = new int[n][n];
		
		for(int g=0; g<n; g++) {
			for(int i=0, j=g; j<n; i++,j++) {
				if(g==0) {
					char ch = s1.charAt(i);
					// if char is true
					if(ch=='T') {
						dpt[i][j] = 1;
						dpf[i][j] = 0;
					}
					// if char is false
					else {
						dpt[i][j] = 0;
						dpf[i][j] = 1;
					}
				}
				
				else {
					for(int k=i; k<j; k++) {
						// find operator
						char oprtr = s2.charAt(k);
						// no. of ways in which expression at left of operator will give true
						int ltc = dpt[i][k];
						// no. of ways in which expression at right of operator will give true
						int rtc = dpt[k+1][j];
						// no. of ways in which expression at left of operator will give false
						int lfc = dpf[i][k];
						// no. of ways in which expression at right of operator will give false
						int rfc = dpf[k+1][j];
						
						/*
						 * if operator is &
						 * then for expression being true both expression left and right should be true
						 * the product of both will give the dpt value
						 * 
						 * other combinations will give false
						 * sum of products of other combinations will give dpf value
						 * */
						if(oprtr=='&') {
							dpt[i][j] += ltc*rtc;
							dpf[i][j] += lfc*rtc + ltc*rfc + lfc*rfc;
						}
						
						/*
						 * if operator is |
						 * then for expression being false both expression left and right should be false
						 * the product of both will give the dpf value
						 * 
						 * other combinations will give true
						 * sum of products of other combinations will give dpt value
						 * */
						else if(oprtr=='|') {
							dpt[i][j] += ltc*rtc + lfc*rtc + ltc*rfc;
							dpf[i][j] += lfc*rfc;
						}
						/*
						 * if operator is ^
						 * then for expression being true one operand should be true and one should be false
						 * the sum of product of both will give the dpt value
						 * 
						 * for expression being false either both operands should be true or false
						 * the sum of product of both will give the dpf value
						 * */
						else { // xor^
							dpt[i][j] += ltc*rfc + lfc*rtc;
							dpf[i][j] += lfc*rfc + ltc*rtc;
						}
					}
				}
			}
		}
		
		return dpt[0][n-1];
	}
}
