/*
Question:
Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.

Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.
*/

package solution;
import java.util.*;
import java.util.stream.*;
public class MinimumSwaps {
	
	public static void main(String[] args) {
		int[] arr = {1,5,4,3,2};
		int n = arr.length;
		System.out.println(minSwaps(arr, n));
	}

	private static int minSwaps(int[] arr, int n) {
		int count = 0;
		
		ArrayList<Pair> res = new ArrayList<>();
		for(int i=0; i<n; i++) {
			res.add(new Pair(arr[i], i));
		}
		
		res.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.first < o2.first)
					return -1;
				else if(o1.first == o2.first)
					return 0;
				return 1;
			}
		});
		
		for(int i=0; i<n; i++) {
			if(res.get(i).second==i) {
				continue;
			}
			else {
				count++;
				int temp1 = res.get(i).second;
				int temp2 = res.get(res.get(i).second).second;
				res.get(temp2).second = temp2;
				res.get(temp1).second = temp1;
				i--;
			}
		}

		return count;
	}

}

class Pair{
	int first;
	int second;
	
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}
