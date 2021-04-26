/*
Question:
Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems.

The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …  
*/

import java.util.*;

public class Catalan {

	public static void main(String args[])
	{
		  for (int i = 0; i < 10; i++) {
	            System.out.print(catalan(i) + " ");
	        }
	}

	private static int catalan(int n) {
		int catalan[] = new int[n + 2];
		 
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i]
                    += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[n];
	}

}