/*
Reference: https://www.youtube.com/watch?v=4ggF3tXIAp0

Question:
Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.

Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.

*/

package solution;
import java.util.*;
public class FindAllFourSumNumbers {
	
	public static void main(String[] args) {
		int[] arr = {10,2,3,4,5,7,8};
		int n = arr.length;
		int k = 23;
		System.out.println(findAllFourNumbers(arr, n, k));
	}

	private static List<List<Integer>> findAllFourNumbers(int[] arr, int n, int k) {
		Arrays.sort(arr);
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int target = k - arr[j] - arr[i];
				int left = j+1;
				int right = n-1;
				
				while(left<right) {
					int sum = arr[left] + arr[right];
					
					if(sum<target) left++;
					
					else if(sum>target) right--;
					
					else {
						List<Integer> sub = new ArrayList<>();
						sub.add(arr[i]);
						sub.add(arr[j]);
						sub.add(arr[left]);
						sub.add(arr[right]);
						res.add(sub);
						
						// processing the duplicates of number 3
						while(left<right && sub.get(2)==arr[left]) {
							left++;
						}
						
						// processing the duplicates of number 4
						while(left<right && sub.get(3)==arr[right]) {
							right--;
						}
					}
				}
				
				// processing the duplicates of number 2
				while(j+1<n && arr[j+1]==arr[j]) {
					j++;
				}
			}
			
			// processing the duplicates of number 1
			while(i+1<n && arr[i+1]==arr[i]) {
				i++;
			}
		}
		return res;
	}	
}
