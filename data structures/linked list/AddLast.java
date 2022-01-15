/*
 * Question: Add last in linked list
 * 
 * Sample input:
 * addLast 3
 * addLast 4
 * addLast 5
 * quit
 * 
 * Sample output:
 * 3
 * 4
 * 5
 * Size= 3
 * Tail = 5
 * */
package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddLast {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if(size == 0) {
				head = tail = temp;
			}
			
			else {
				tail.next = temp;
				tail = temp;
			}
			
			size++;
		}
	}
	
	public static void testList(LinkedList list) {
	    for (Node temp = list.head; temp != null; temp = temp.next) {
	      System.out.println(temp.data);
	    }
	    System.out.println("Size= " + list.size);

	    if (list.size > 0) {
	      System.out.println("Tail = " + list.tail.data);
	    }
	  }
	
	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LinkedList list = new LinkedList();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("addLast")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        list.addLast(val);
	      }
	      str = br.readLine();
	    }

	    testList(list);
	  }

}
