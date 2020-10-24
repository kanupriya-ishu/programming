import java.util.*;

public class DecToBin {
	
	static final int MAX = 100;
	static int[] s = new int[MAX];
	static int top;
	
	DecToBin()
	{
		top = -1;
	}
	
	static void push(int s[], int x)
	{
		if (top >= (MAX - 1)) { 
            System.out.println("Stack Overflow"); 
           
        } 
        else { 
            s[++top] = x; 
            System.out.println(x + " pushed into stack"); 
            
        } 
	}
	
	static int pop(int s[])
	{
		if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            int x = s[top--]; 
            return x; 
        } 
		
	}
	
	static void print(int s[])
	{
		for(int i=top; i>=0; i--)
		{
			System.out.println("|"+s[i]+"|");
		}
	}


}
