/*
Question:
Write an efficient program to print all the duplicates and their counts in the input string
*/

import java.util.*;
public class DuplicateCharacters {

    public static void main(String args[]) 
    {  
    	String s = "test string";
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	// fill HashMap
    	for(int i=0; i<s.length(); i++) {
    		if(!map.containsKey(s.charAt(i))) {
    			map.put(s.charAt(i), 1);
    		}
    		
    		else {
    			map.put(s.charAt(i), map.get(s.charAt(i))+1);
    		}
    	}
    	
    	for(Map.Entry i : map.entrySet()) {
    		char key = (char)i.getKey();
    		int value = (int)i.getValue();
    		
    		if(value>1) {
    			System.out.println(key + " : "+value);
    		}
    	}
        
    }
    
    
}