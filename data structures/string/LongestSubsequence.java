/*
Question:
Given a string, find the length of the longest repeating subsequence such that the two subsequences don’t have same string character at the same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.

Examples:

Input: str = "abc"
Output: 0
There is no repeating subsequence

Input: str = "aab"
Output: 1
The two subssequence are 'a'(first) and 'a'(second). 
Note that 'b' cannot be considered as part of subsequence 
as it would be at same index in both.

Input: str = "aabb"
Output: 2

Input: str = "axxxy"
Output: 2
*/