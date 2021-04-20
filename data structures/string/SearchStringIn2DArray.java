/*
Question:
Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form).
The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
Example: 
Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "GEEKS"

Output: pattern found at 0, 0
        pattern found at 0, 8
        pattern found at 1, 0
Explanation: 'GEEKS' can be found as prefix of
1st 2 rows and suffix of first row

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "EEE"

Output: pattern found at 0, 2
        pattern found at 0, 10
        pattern found at 2, 2
        pattern found at 2, 12
Explanation: EEE can be found in first row 
twice at index 2 and index 10
and in second row at 2 and 12
*/
 
import java.util.*;
public class SearchStringIn2DArray {
	
	static int row, col;
	
	// 8 directions
	static int[] x = {0,0,-1,1,1,-1,1,-1};
	static int[] y = {-1,1,0,0,1,-1,-1,1};
	
	public static void main(String args[])
	{
		 char arr[][] =  { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
			               { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
			               { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		 
		row = arr.length;
		col = arr[0].length;
		searchPattern(arr, "GEEKS");

	}
	
	

	private static void searchPattern(char[][] arr, String s) {
		for (int i = 0; i < row; i++) {
            for (int j= 0; j < col; j++) {
                if (search2D(arr, i, j, s))
                    System.out.println(
                        "pattern found at " + i + ", " + j);
            }
        }		
	}



	private static boolean search2D(char[][] arr, int r, int c, String s) {
		if(arr[r][c]!=s.charAt(0)) {
			return false;
		}
		
		int len = s.length();
		
		// search in all 8 directions
		for(int dir=0; dir<8; dir++) {
			
			int k, row_dir = r + x[dir], col_dir = c + y[dir];
			for(k=1; k<len; k++) {
				if(row_dir>=row || col_dir>=col || row_dir<0 || col_dir<0) {
					break;
				}
				
				if(arr[row_dir][col_dir]!=s.charAt(k)) {
					break;
				}
				
				row_dir += x[dir];
				col_dir += y[dir];
			}
			
			if(k==len) {
				return true;
			}
		}
		return false;
	}
}