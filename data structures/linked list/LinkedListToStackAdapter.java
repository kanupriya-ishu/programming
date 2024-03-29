/*
 * Question: Linked List to Stack Adapter
 * 
 * Sample input:
 * push 10
 * push 20
 * push 30
 * pop
 * top
 * size
 * quit
 * 
 * Sample output:
 * 30
 * 20
 * 2
 * */
package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListToStackAdapter {
	public static class LLToStackAdapter {
	    LinkedList<Integer> list;

	    public LLToStackAdapter() {
	      list = new LinkedList<>();
	    }


	    int size() {
	      return list.size();
	    }

	    void push(int val) {	      
	      list.addFirst(val);
	    }

	    int pop() {
	    	if(list.size()==0) {
	    		System.out.println("Stack underflow");
		    }
	    	else {
	    		return list.removeFirst();
	    	}
	    	return -1;
	    }

	    int top() {
	    	if(list.size()==0) {
	    		System.out.println("Stack underflow");
		    }
	    	else {
	    		return list.getFirst();
	    	}
	    	return -1;
	    }
	  }

	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LLToStackAdapter st = new LLToStackAdapter();

	    String str = br.readLine();
	    while(str.equals("quit") == false){
	      if(str.startsWith("push")){
	        int val = Integer.parseInt(str.split(" ")[1]);
	        st.push(val);
	      } else if(str.startsWith("pop")){
	        int val = st.pop();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("top")){
	        int val = st.top();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("size")){
	        System.out.println(st.size());
	      }
	      str = br.readLine();
	    }

	}
}
