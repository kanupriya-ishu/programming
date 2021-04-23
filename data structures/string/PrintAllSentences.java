/*
Question:
Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion? 

Example: 

Input: {{"you", "we"},
        {"have", "are"},
        {"sleep", "eat", "drink"}}

Output:
  you have sleep
  you have eat
  you have drink
  you are sleep
  you are eat
  you are drink
  we have sleep
  we have eat
  we have drink
  we are sleep
  we are eat
  we are drink 

*/

import java.util.*;

public class PrintAllSentences {
	
	private static int R, C;

	public static void main(String args[])
	{
		String[][] str = {{"you", "we", ""},
					      {"have", "are", ""},
					      {"sleep", "eat", "drink"}};
        
		R = str.length;
		C = str[0].length;
        String sen = "";
        
        print(str, sen, 0);
        
	}

	private static void print(String[][] str, String sen, int r) {
		if(r==R) {
			System.out.println(sen);
			return;
		}
		
		for(int i=0; i<C; i++) {
			if(str[r][i] != "") {
				print(str, sen + " " + str[r][i], r+1);
			}
		}
	}
}