/*
Question:
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

*/

import java.util.*;
public class SearchInARotatedArray {
	
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int n = nums.length;
		int target = 0;
		System.out.println(search(nums, n, target));
	}

	private static int search(int[] nums, int n, int target) {
		int l = 0;
		int r = n-1;
		// find the index of the smallest value using binary search.
        // Loop will terminate since mid < r, and l or r will shrink by at least 1.
        // Proof by contradiction that mid < r: if mid==r, then l==r and loop would have been terminated.
		while(l<r) {
			int mid = l + (r-l)/2;
			if(nums[mid]>nums[r])
				l = mid+1;
			else
				r = mid;
		}
		
		/*
		 * If we want to find realmid for array [4,5,6,7,0,1,2], you can shift the part before the rotating point to the end of 
		 * the array (after 2) so that the sorted array is "recovered" from the rotating point but only longer, like this: 
		 * [4, 5, 6, 7, 0, 1, 2, 4, 5, 6, 7]. The real mid in this longer array is the middle point between the rotating point and 
		 * the last element: (rot + (hi+rot)) / 2. (hi + rot) is the index of the last element. And of course, this result is larger 
		 * than the real middle. So you just need to wrap around and get the remainder: ((rot + (hi + rot)) / 2) % n. And this 
		 * expression is effectively (rot + hi/2) % n, which is (rot+mid) % n.*/
		int rot = l;
		l = 0;
		r = n-1;
		while(l<=r) {
			int mid = l + (r-l)/2;
			int realmid = (mid+rot)%n;
			
			if(nums[realmid]==target)
				return realmid;
			else if(nums[realmid]>target)
				r = mid-1;
			else
				l = mid+1;
		}
		return -1;
	}
}

