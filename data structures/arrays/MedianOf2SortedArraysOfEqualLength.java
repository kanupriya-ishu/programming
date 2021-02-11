/*
Median of 2 sorted arrays of different size
*/

public class MedianOf2SortedArraysOfEqualSize {

    public static void main(String args[]) 
    {  
    	// array 1
    	int[] arr1 = {1,2,3};
    	
    	// array 2
    	int[] arr2 = {4,14,20};
    	
    	
    	int n = arr1.length;
    	
    	int[] arr3 = new int[2*n];
    	
    	int len=0;
    	int i=0, j=0;
    	
    	//merge both arrays
    	while(i<n && j<n) {
    		if(arr1[i]<arr2[j]) {
    			arr3[len++] = arr1[i++];
    		}
    		else {
    			arr3[len++] = arr2[j++];
    		}
    	}
    	
    	if(i==n) {
    		while(j<n) {
    			arr3[len++] = arr2[j++];
    		}
    	}
    	
    	else {
    		while(i<n) {
    			arr3[len++] = arr1[i++];
    		}
    	}
    	
    	System.out.println("Merged array: \n"+Arrays.toString(arr3));
    	float median; 
    	
    	median =(float) (arr3[n-1]+arr3[n])/2;
    	
    	
    	System.out.println(median);
    }
    
}