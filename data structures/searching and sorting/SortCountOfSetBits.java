/*
Question:
Given an array of integers, sort the array (in descending order) according to count of set bits in binary representation of array elements. 

Note: For integers having same number of set bits in their binary representation, sort according to their position in the original array i.e., a stable sort.

 
Example 1:
Input: 
arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
Output:
15 7 5 3 9 6 2 4 32
Explanation:
The integers in their binary
representation are:
15 - 1111
7  - 0111
5  - 0101
3  - 0011
9  - 1001
6  - 0110
2  - 0010
4  - 0100
32 - 10000
hence the non-increasing sorted order is:
{15}, {7}, {5, 3, 9, 6}, {2, 4, 32}
 
Example 2:
Input: 
arr[] = {1, 2, 3, 4, 5, 6};
Output: 
3 5 6 1 2 4
Explanation:
3  - 0011
5  - 0101
6  - 0110
1  - 0001
2  - 0010
4  - 0100
hence the non-increasing sorted order is
{3, 5, 6}, {1, 2, 4}
*/

package solution;
import java.util.*;
import java.util.stream.*;
public class SortCountOfSetBits {
	
	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 6, 2};
		int n = arr.length;
		sortBySetBitCount(arr, n);
	}

	/*
	 * Create a MultiMap whose key values will be the negative of the number of set-bits of the element.
	 * Traverse the array and do following for each element:
	 * Count the number set-bits of this element. Let it be ‘setBitCount’ count.insert({(-1) * setBitCount, element})
	 * Traverse ‘count’ and print the second elements.
	 * */
	static void sortBySetBitCount(int[] arr, int n)
	  {
	    ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();
	 
	    // Iterate over all values and
	    // insert into multimap
	    for( int i = 0 ; i < n ; ++i )
	    {
	      count.add(new ArrayList<Integer>(Arrays.asList((-1) * countSetBits(arr[i]), arr[i])));
	    }
	 
	    Collections.sort(count, new Comparator<ArrayList<Integer>>() {   
	      @Override
	      public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
	        return o1.get(0).compareTo(o2.get(0));
	      }              
	    });
	 
	    for(int i = 0; i < count.size(); i++)
	    {
	      System.out.print(count.get(i).get(1) + " ");
	    }
	 
	  }
	

	static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
	
	
}
