/*
Question:
Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is smaller than the line width. When line breaks are inserted there is a possibility that extra spaces are present in each line. The extra spaces includes spaces put at the end of every line except the last one. 
The problem is to minimize the following total cost. 
Total cost = Sum of cost of all lines, where cost of line is = (Number of extra spaces in the line)^2. 
For example, consider the following string and line width M = 15 
"Geeks for Geeks presents word wrap problem" 
Following is the optimized arrangement of words in 3 lines 
Geeks for Geeks 
presents word 
wrap problem 
The total extra spaces in line 1 and line 2 are 0 and 2. Space for line 3 is not considered as it is not extra space as described above. So optimal value of total cost is 0 + 2*2 = 4.
Examples:
 


Input format: Input will consists of array of integers where each array element represents length of each word of string. For example, for string S = "Geeks for Geeks", input array will be arr[] = {5, 3, 5}.

Output format: Output consists of a series of integers where two consecutive integers represent 

starting word and ending word of each line.



Input : arr[] = {3, 2, 2, 5}

Output : 1 1 2 3 4 4

Line number 1: From word no. 1 to 1

Line number 2: From word no. 2 to 3

Line number 3: From word no. 4 to 4 



Input : arr[] = {3, 2, 2}

Output : 1 1 2 2 3 3

Line number 1: From word no. 1 to 1

Line number 2: From word no. 2 to 2

Line number 3: From word no. 3 to 3 
*/

import java.util.*;
public class WordWrapProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,2,5};
		int k = 6;
		wordWrap(arr, k);
	}
	
	// function to print answer
	private static void printp(int p[], int n) {
		if(p[n]==1)
			System.out.print(p[n] + " " + n + " ");
		else {
			printp(p, p[n]-1);
			System.out.print(p[n] + " " + n + " ");
		}
	}

	private static void wordWrap(int[] a, int k) {
		// TODO Auto-generated method stub
		int n = a.length;
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = a[i-1];
		}
		
		// space[i][j] stores the number of
		// spaces at the end of line starting with ith word
		int[][] space = new int[n+1][n+1];
		// cost[i][j] stores the cost of space at the end of line
		int[][] cost = new int[n+1][n+1];
		// this stores the minimum cost till ith index
		int[] c = new int[n+1];
		// this stores the path to print
		int[] p = new int[n+1];
		
		// infinity variable
		int inf = Integer.MAX_VALUE;
		
		for(int i=1; i<=n; i++) {
			// cost of ith element will be 
			// total no. of chars - the no. of characters of ith word
			space[i][i] = k - arr[i];
			for(int j=i+1; j<=n; j++) {
				// starting from next word of ith word, space left at end will be calculated by 
				// remaining characters - characters of the current word - 1 (for space between words)
				space[i][j] = space[i][j-1] - arr[j]-1;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				// if space is negative the word can't be accommodated therefore we will put inf value there
				if(space[i][j]<0) {
					cost[i][j] = inf;
				}
				
				// if it is the last line and space is 0 or positive, cost will be 0
				else if(j==n && space[i][j]>=0) {
					cost[i][j] = 0;
				}
				// else square of space will be stored
				else {
					cost[i][j] = space[i][j] * space[i][j];
				}
			}
		}
		
		c[0] = 0;
		for(int i=1; i<=n; i++) {
			// assume  initial cost to infinity
			c[i] = inf;
			for(int j=1; j<=i; j++) {
				// if previous cost is not infinity and 
				// previous cost + cost of current word 
				// is less than current cost then that 
				// will stored as answer and p will store 
				// the index for path
				if(c[j-1]!=inf && cost[j][i]!=inf &&
					c[j-1]+cost[j][i] < c[i]) {
					c[i] = c[j-1] + cost[j][i];
					p[i] = j;
				}
			}
		}
		
		printp(p, n);
		
	}

}
