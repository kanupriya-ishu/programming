/*

*/
public class SmallestSubarrayWithSumGraterThanX {

    public static void main(String args[]) 
    {  
    	// array
    	int[] arr = {1, 10, 5, 2, 7};
    	// given value
    	int x = 9;
    	
    	int sum = 0;
    	// minimum length of sub array
    	int len = arr.length+1;
    	
    	int left = 0;
    	int right = 0;
    		
    	while(right<arr.length) {
    		// keep adding till sum is equal to or greater than giving value
    		while(sum<=x  && right<arr.length) {
    			sum+=arr[right++];
    		}
    		
    		
    		while(sum>x && left<arr.length) {
    			
    			// update minimum length
    			if(right-left<len) {
    				len = right-left;
    			}
    			
    			// subtract values from beginning of sub array
    			sum-=arr[left++];
    		}
    	}
    	
    	System.out.println(len);
    	
    }
    
}