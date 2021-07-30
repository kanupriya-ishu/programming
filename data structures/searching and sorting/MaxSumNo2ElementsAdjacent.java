/*
Reference: https://www.youtube.com/watch?v=VT4bZV24QNo

Question:
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

Example 1:

Input:
n = 6
a[] = {5,5,10,100,10,5}
Output: 110
Explanation: 5+100+5=110

Example 2:

Input:
n = 3
a[] = {1,2,3}
Output: 4
Explanation: 1+3=4
*/

package solution;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) {
		int[] arr = {5,5,10,100,10,5};
		int n = arr.length;
		System.out.println(findMax(arr, n));
	}

	private static int findMax(int[] arr, int n) {
		// inc contains max value of non adjacent elements including the ith elemnt
		int inc = arr[0];
		// exc contains max value of non adjacent elements excluding the ith elemnt
		int exc = 0;
		
		for(int i=1; i<n; i++) {
			// New excluded element will be maximum of previous exc and inc
			int new_exc = Math.max(exc, inc);
			inc = exc + arr[i];
			exc = new_exc;
		}
		
		return Math.max(inc, exc);
	}

}
