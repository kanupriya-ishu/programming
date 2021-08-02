/*
Reference: https://www.youtube.com/watch?v=C9-n_H7dsvU

Question:
ou are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.


Example 1:

Input:
n = 6
arr[] = {0,0,5,5,0,0}
Output: 6
Explanation: The 6 subarrays are 
[0], [0], [0], [0], [0,0], and [0,0].

Example 2:

Input:
n = 10
arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
Output: 4
Explanation: The 4 subarrays are [-1 -3 4]
[-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

*/

package solution;
import java.util.*;
public class ZeroSumSubarrays {
	
	public static void main(String[] args) {
		int[] arr = {6,-1,-3,4,-2,2,4,6,-12,-7};
		int n = arr.length;
		System.out.println(count(arr, n));
	}

	private static int count(int[] arr, int n) {
		int count = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		int sum = 0;
		
		/*
		 * Logic:
		 * Keep on calculating sum
		 * For each sum check if it exists in hashmap
		 * if it does add its frequency to count
		 * otherwise add the sum in the hashmap with frequency 1
		 * */
		for(int i=0; i<n; i++) {
			sum += arr[i];
			if(map.containsKey(sum)) {
				int val = map.get(sum);
				count+= val;
				map.put(sum, val + 1);
			}
			else {
				map.put(sum, 1);
			}
		}
		
		return count;
	}
	
}
