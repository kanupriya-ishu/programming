/*
	Given an integer, the task is to find factorial of the number.
	 
	Input:
	The first line of input contains an integer T denoting the number of test cases.  
	The first line of each test case is N,the number whose factorial is to be found
	 
	Output:
	Print the factorial of the number in separate line.
	 
	Constraints:
	1 ≤ T ≤ 100
	1 ≤ N ≤ 1000
	 
	Example:
	Input
	3
	5
	10
	2
	 
	Output
	120
	3628800
	2
*/

import java.util.*;
public class FactorialOfLargeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		
		sc.close();
		
		int[] res = new int[500];
		res[0] = 1;
		int res_len = 1;
		
		for(int i=2; i<=n; i++) {
			res_len = multiply(res, i, res_len);
		}
		
		System.out.println("Factorial of "+n+" is ");
		for(int i=res_len-1; i>=0; i--) {
			System.out.print(res[i]);
		}
	}

	private static int multiply(int[] res, int i, int res_len) {
		// TODO Auto-generated method stub
		int carry = 0;
		
		for(int j=0; j<res_len; j++) {
			int product = res[j]*i + carry;
			res[j] = product%10;
			carry = product/10;
		}
		
		while(carry!=0) {
			res[res_len] = carry%10;
			carry = carry/10;
			res_len++;
		}
		
		return res_len;
	}

}
