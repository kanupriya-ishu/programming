/*
Question:
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
*/

import java.util.*;
public class StringRotation {

    public static void main(String args[]) 
    {  
    	String s1 = "ABCD";
        String s2 = "ACBD";
        
        // string s3 = s1 + s1
        String s3 = s1.concat(s1);
        
        // if s2 is substring of s3 then it is rotation of s1
        if(s1.length()==s2.length() && s3.indexOf(s2)!=-1) {
        	System.out.println(s2 + " is rotation of "+s1);
        }
        
        else {
        	System.out.println(s2 + " is not rotation of "+s1);
        }
    }     
}