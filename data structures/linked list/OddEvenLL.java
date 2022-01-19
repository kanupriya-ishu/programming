/*
Question: You are required to complete the body of oddEven function. The function is expected to tweak the list such that all odd values are followed by all even values. The relative order of elements should not change. Also, take care of the cases when there are no odd or no even elements. Make sure to properly set head, tail and size as the function will be tested by calling addFirst and addLast

Sample input
7
2 8 9 1 5 4 3
10
100
 
Sample output:
2 8 9 1 5 4 3 
9 1 5 3 2 8 4 
10 9 1 5 3 2 8 4 100 
  */
package solution;

import java.io.*;
import java.util.*;

public class OddEvenLL {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size - 1;
            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI() {
            if (size <= 1) {
                return;
            }

            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        public int mid() {
            Node f = head;
            Node s = head;

            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }

            return s.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node one = l1.head;
            Node two= l2.head;
            
            LinkedList list = new LinkedList();
            
            while(one!=null && two!=null) {
            	if(one.data < two.data) {
            		list.addLast(one.data);
            		one = one.next;
            	}
            	else {
            		list.addLast(two.data);
            		two= two.next;
            	}
            }
            
            while(one!=null) {
            	list.addLast(one.data);
            	one = one.next;
            }
            
            while(two!=null) {
            	list.addLast(two.data);
            	two = two.next;
            }
            
            return list;
        }
        
        private static Node midNode(Node head, Node tail) {
			Node slow = head;
			Node fast = tail;
			
			while(fast!=tail && fast!=tail.next) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		public static LinkedList mergeSort(Node head, Node tail) {
			if(head==tail) {
				LinkedList temp = new LinkedList();
				temp.addLast(head.data);
				return temp;
			}
			Node mid = midNode(head, tail);
			LinkedList fh = mergeSort(head, mid);
			LinkedList sh = mergeSort(mid.next, tail);
			LinkedList res = mergeTwoSortedLists(fh, sh);
			return res;
		}

		public void removeDuplicates() {
			LinkedList temp = new LinkedList();
			
			while(this.size()>0) {
				int val = this.getFirst();
				this.removeFirst();
				if(temp.size()==0 || temp.tail.data!=val) {
					temp.addLast(val);
				}
			}
			this.head = temp.head;
			this.tail = temp.tail;
			this.size = temp.size;
		}

		public void oddEven() {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();
			
			while(this.size>0) {
				int val = this.getFirst();
				this.removeFirst();
				
				if(val%2==0) {
					even.addLast(val);
				}
				else {
					odd.addLast(val);
				}
			}
			
			if(odd.size>0 && even.size>0) {
				this.head = odd.head;
				odd.tail.next = even.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			}
			else if(odd.size>0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			}
			else if(even.size>0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}

    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
          int d = Integer.parseInt(values1[i]);
          l1.addLast(d);
        }

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.oddEven();
        l1.display();
        l1.addFirst(a);
        l1.addLast(b);
        l1.display();
    }
}