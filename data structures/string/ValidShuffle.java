/*
Question:
Check if a string is a valid shuffle of two other strings
1XY2 is a valid shuffle of XY and 12
Y12X is not a valid shuffle of XY and 12
In the above example, we have a string array named results. It contains two strings: 1XY2 and Y12X. We are checking if these two strings are valid shuffle of strings first(XY) and second(12).

Here, the program says 1XY2 is a valid shuffle of XY and 12. However, Y12X is not a valid shuffle.

This is because Y12X has altered the order of string XY. Here, Y is used before X. Hence, to be a valid shuffle, the order of string should be maintained.
*/

import java.util.*;
public class ValidShuffle {

    public static void main(String args[]) 
    {  
    	String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y12X"};
        
        for(int res=0; res<results.length; res++) {
        	if(checkShuffle(first, second, results[res])==true)
        		System.out.println("valid");
        	else
        		System.out.println("invalid");
        }
    }

	public static boolean checkShuffle(String first, String second, String res) {
		int i=0, j=0, k=0;
		
		if(first.length()+second.length()!=res.length()) {
			return false;
		}
		
		while(k<res.length()) {
			if(i<first.length() && first.charAt(i)==res.charAt(k)) {
				i++;
			}
			
			else if(j<second.length() && second.charAt(j)==res.charAt(k)) {
				j++;
			}
			
			else {
				return false;
			}
			
			k++;
		}
		
		if(i!=first.length() || j!=second.length())
			return false;
		return true;
	}     
}