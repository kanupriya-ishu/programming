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