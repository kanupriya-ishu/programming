/* 
Median of 2 sorted arrays of different size
*/

public class MedianOf2SortedArraysOfDifferentLength {

    public static void main(String args[]) 
    {  
    	// array 1
    	int[] arr1 = {-5, 3, 6, 12, 15};
    	
    	// array 2
    	int[] arr2 = {-12, -10, -6, -3, 4, 10};
    	
    	
    	int n1 = arr1.length;
    	int n2 = arr2.length;
    	
    	int[] arr3 = new int[n1+n2];
    	
    	int len=0;
    	int i=0, j=0;
    	
    	//merge both arrays
    	while(i<n1 && j<n2) {
    		if(arr1[i]<arr2[j]) {
    			arr3[len++] = arr1[i++];
    		}
    		else {
    			arr3[len++] = arr2[j++];
    		}
    	}
    	
    	if(i==n1) {
    		while(j<n2) {
    			arr3[len++] = arr2[j++];
    		}
    	}
    	
    	else {
    		while(i<n1) {
    			arr3[len++] = arr1[i++];
    		}
    	}
    	
    	System.out.println("Merged array: \n"+Arrays.toString(arr3));
    	int median; 
    	
    	// if odd elements are there then middle element is median
    	if((n1+n2)%2==1) {
    		median = arr3[arr3.length/2];
    	}
    	
    	//if even elements are there then average of two elements in middle is median
    	else {
    		median = (arr3[arr3.length/2-1]+arr3[arr3.length/2])/2;
    	}
    	
    	System.out.println(median);
    }
    
}