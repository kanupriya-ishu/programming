/*
 * Question: Linked List to Stack Adapter
 * 
 * Sample input:
 * add 1
 * add 2
 * add 3
 * remove
 * peek
 * size
 * quit
 * 
 * Sample output:
 * 1
 * 2
 * 2
 * */
package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListToQueueAdapter {
	public static class LLToQueueAdapter {
	    LinkedList<Integer> list;

	    public LLToQueueAdapter() {
	      list = new LinkedList<>();
	    }

	    int size() {
	      return list.size();
	    }

	    void add(int val) {
	      list.addLast(val);
	    }

	    int remove() {
	      if(size()==0) {
	    	  System.out.println("Queue underflow");
	    	  return -1;
	      }
	      else {
	    	  return list.removeFirst();
	      }
	    }

	    int peek() {
	    	if(size()==0) {
		    	  System.out.println("Queue underflow");
		    	  return -1;
		      }
		      else {
		    	  return list.getFirst();
		      }
	    }
	  }

	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LLToQueueAdapter qu = new LLToQueueAdapter();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("add")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        qu.add(val);
	      } else if (str.startsWith("remove")) {
	        int val = qu.remove();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("peek")) {
	        int val = qu.peek();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("size")) {
	        System.out.println(qu.size());
	      }
	      str = br.readLine();
	    }
	  }
}
