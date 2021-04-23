/*
Question:
Given a string S delete the characters which are appearing more than once consecutively.

Example 1:

Input:
S = aabb
Output:  ab 
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
Similiar explanation for b at
4th position.

Example 2:

Input:
S = aabaa
Output:  aba
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
'a' at fifth position is appearing
2nd time consecutively.
*/

import java.util.*;

public class RemoveAdjacentDuplicates {

	public static void main(String args[])
	{
		String str = "aabaa";
		System.out.println(removeConsecutiveChars(str));
	}

	private static String removeConsecutiveChars(String str) {
		String ans = "";
		Stack<Character> stack = new Stack<>();
		
		int n = str.length();
		
		stack.push(str.charAt(0));
		for(int i=1; i<n; i++) {
			if(stack.peek()!=str.charAt(i)) {
				stack.push(str.charAt(i));
			}
		}
		
		while(!stack.isEmpty()) {
			ans = stack.pop() + ans;
		}
		
		return ans;
	}
}