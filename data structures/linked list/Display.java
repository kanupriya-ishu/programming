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

public class Display {

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
		
		public int size() {
			return size;
		}
		
		public void display() {
			for(Node temp=head; temp!=null; temp = temp.next) {
				System.out.print(temp.data + " ");
			}
			System.out.println();
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
	      } else if (str.startsWith("size")) {
	        System.out.println(list.size());
	      } else if (str.startsWith("display")) {
	        list.display();
	      }
	      str = br.readLine();
	    }
	  }

}
