/*
Question:
Write a function “runCustomerSimulation” that takes following two inputs
a) An integer ‘n’: total number of computers in a cafe and a string:
b) A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs. The first occurrence indicates the arrival of a customer; the second indicates the departure of that same customer.

A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times.
Customers who leave without using a computer always depart before customers who are currently using the computers. There are at most 20 computers per cafe.

For each set of input the function should output a number telling how many customers, if any walked away without using a computer. Return 0 if all the customers were able to use a computer.

runCustomerSimulation (2, “ABBAJJKZKZ”) should return 0

runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1 as ‘D’ was not able to get any computer

runCustomerSimulation (3, “GACCBGDDBAEE”) should return 0

runCustomerSimulation (1, “ABCBCA”) should return 2 as ‘B’ and ‘C’ were not able to get any computer.

runCustomerSimulation(1, “ABCBCADEED”) should return 3 as ‘B’, ‘C’ and ‘E’ were not able to get any computer.
*/

import java.util.*;

public class FindNoOfCustomers {
	
	private static int MAX_CHARS = 26;

	public static void main(String args[])
	{
		System.out.println(findNoOfCustomers(2, "ABBAJJKZKZ".toCharArray())); 
	    System.out.println(findNoOfCustomers(3, "GACCBDDBAGEE".toCharArray())); 
	    System.out.println(findNoOfCustomers(3, "GACCBGDDBAEE".toCharArray())); 
	    System.out.println(findNoOfCustomers(1, "ABCBCA".toCharArray())); 
	}
	
	public static int findNoOfCustomers(int n, char[] seq) {
		
		// seen[i] = 0, indicates that customer 'i' is not in cafe 
	    // seen[i] = 1, indicates that customer 'i' is in cafe but 
	    //         computer is not assigned yet. 
	    // seen[i] = 2, indicates that customer 'i' is in cafe and 
	    //         has occupied a computer. 
		char[] seen = new char[MAX_CHARS];
		
		int ans = 0;
		
		int occupied = 0;
		
		for(int i=0; i<seq.length; i++) {
			 int index = seq[i] - 'A';
			 
			 if(seen[index]==0) {
				 seen[index] = 1;
				 
				 if(occupied<n) {
					 occupied++;
					 seen[index] = 2;
				 }
				 
				 else {
					 ans++;
				 }
			 }
			 
			 else {
				 if(seen[index]==2) {
					 occupied--;
				 }
				 seen[index] = 0;
			 }
		}
		
		return ans;
	}
}