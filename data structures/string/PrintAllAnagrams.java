/*
Question:
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.


Example 1:

Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output: 
god dog
act cat tac
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.

Example 2:

Input:
N = 3
words[] = {no,on,is}
Output: 
no on
is
Explanation:
There are 2 groups of
anagrams "no", "on" make group 1.
"is" makes group 2. 
*/
 
import java.util.*;

public class PrintAllAnagrams {

	public static void main(String args[])
	{
		String[] strs = {"act", "god", "cat", "dog", "tac"};
		
		List<List<String>> groupedAnagrams = groupAnagrams(strs);
		
		System.out.println(groupedAnagrams);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupedAnagrams = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(String current: strs) {
			char[] characters = current.toCharArray();
			Arrays.sort(characters);
			String sorted = new String(characters);
			if(!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			
			map.get(sorted).add(current);
		}
		
		groupedAnagrams.addAll(map.values());		
		return groupedAnagrams;
	}
}