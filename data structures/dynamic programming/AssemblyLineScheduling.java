/*
Question:
A car factory has two assembly lines, each with n stations. A station is denoted by Si,j where i is either 1 or 2 and indicates the assembly line the station is on, and j indicates the number of the station.
The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work like engine fitting, body fitting, painting, and so on. So, a car chassis must pass through each of the n stations
in order before exiting the factory. The parallel stations of the two assembly lines perform the same task. After it passes through station Si,j, it will continue to station Si,j+1 unless it decides to transfer
to the other line. Continuing on the same line incurs no extra cost, but transferring from line i at station j – 1 to station j on the other line takes time ti,j. Each assembly line takes an entry time ei and 
exit time xi which may be different for the two lines. Give an algorithm for computing the minimum time it will take to build a car chassis.
*/

import java.util.*;

public class AssemblyLineScheduling {

	public static void main(String args[])
	{
		int s[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12};
        int x[] = {18, 7};
  
        System.out.println(carAssembleTime(s, t, e, x));
	}

	private static int carAssembleTime(int[][] s, int[][] t, int[] e, int[] x) {
		int s1 = e[0] + s[0][0]; // initial cost of line 1
		int s2 = e[1] + s[1][0]; // initial cost of line 2
		
		for(int j=1; j<s[0].length; j++) {
			// compare the (cost of line 1 + next spot of line 1) and (line 2 + time delay from line 1 + next spot of line 1)
			int temp_s1 = Math.min(s1 + s[0][j], s2 + t[1][j] + s[0][j]);
			// compare the (cost of line 2 + next spot of line 2) and (line 1 + time delay from line 2 + next spot of line 2)
			int temp_s2 = Math.min(s2 + s[1][j], s1 + t[0][j] + s[1][j]);
			s1 = temp_s1;
			s2 = temp_s2;
		}
		
		// add respective exit values
		s1 += x[0];
		s2 += x[1];
		
		return Math.min(s1, s2);
	}

}