/*
Question:
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

import java.util.*;

public class LongestCommonPrefix {

	static int NO_OF_CHARS = 256;

	public static void main(String args[]) {
		String[] strs = { "flower","flow","flight" };

		if (strs.length == 0)
			System.out.println("NO");
		else {
			String pre = strs[0];
			for (int i = 1; i < strs.length; i++) {
				while (strs[i].indexOf(pre) != 0) {
					pre = pre.substring(0, pre.length() - 1);

				}

			}
		}

	}
}