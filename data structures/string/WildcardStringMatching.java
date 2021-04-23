/*
Question:
Given two strings wild and pattern where wild string may contain wild card characters and pattern string is a normal string. Determine if the two strings match. The following are the allowed wild card characters in first string :-

* --> Matches with 0 or more instances of any 
character or set of characters.
? --> Matches with any one character.

Example 1:

Input: wild = ge*ks
       pattern = geeks
Output: Yes
Explanation: Replace the '*' with 'e' to obtain 
the string.

Example 2:

Input: wild = ge?ks*
       pattern = geeksforgeeks
Output: Yes
Explanation: Replace '?' with 'e' and '*' with
'forgeeks' and it will be same as pattern.
*/