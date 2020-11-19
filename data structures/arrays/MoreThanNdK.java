/*
	Given an array of size n, find all elements in array that appear more than n/k times. For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. There are two elements that appear more than two times, 2 and 3. 
*/

import java.util.*;
public class MoreThanNdK {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter value of k:");
		int k = sc.nextInt();
		
		int NdK = n/k;
		
		sc.close();
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			if(!hm.containsKey(arr[i])) {
				hm.put(arr[i], 1);
			}
			
			else {
				int frequency = hm.get(arr[i]);
				hm.put(arr[i], frequency+1);
				
			}
		}
		
		for(Map.Entry i: hm.entrySet()) {
			Integer temp = (Integer)i.getValue(); 
            if (temp > NdK) 
                System.out.println(i.getKey());
		}
		
	}

}
