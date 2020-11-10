/*
	Given a collection of intervals, merge all overlapping intervals.

	Example 1:

	Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	Example 2:

	Input: intervals = [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.*;
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of intervals:");
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			System.out.println("Start of interval");
			arr[i][0] = sc.nextInt();
			
			System.out.println("End of interval");
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr, (i1, i2)->Integer.compare(i1[0], i2[0]));
		
		List<int[]> ans = new ArrayList<>();
		int[] newInterval = arr[0];
		
		ans.add(newInterval);
		
		for(int[] i: arr) {
			if (i[0]<=newInterval[1]) {
				newInterval[1] = Math.max(i[1], newInterval[1]);
			}
			
			else {
				newInterval = i;
				ans.add(newInterval);
			}
		}
		
		int[][] arr2 = ans.toArray(new int[ans.size()][]);
		for(int i=0; i<arr2.length; i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		

	}

}