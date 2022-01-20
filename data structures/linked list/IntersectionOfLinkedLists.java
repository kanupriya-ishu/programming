/*
Question: You are required to complete the body of findIntersection function. The function is passed two linked lists which start separately but merge at a node and become common thereafter. The function is expected to find the point where two linked lists merge. You are not allowed to use arrays to solve the problem.
Sample input
5
1 2 3 4 5
8
11 22 33 44 55 66 77 88
2
3
 
Sample output:
44 
*/
package solution;

import java.io.*;
import java.util.*;

public class IntersectionOfLinkedLists {
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

		public void kReverse(int k) {
			LinkedList prev = null;
			
			while(this.size>0) {
				LinkedList curr  = new LinkedList();
				
				if(this.size>=k) {
					for(int i=0; i<k; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addFirst(val);
					}
				}
				else {
					int n = this.size();
					for(int i=0; i<n; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addLast(val);
					}					
				}
				
				if(prev==null) {
					prev = curr;
				}
				else {
					prev.tail.next = curr.head;
					prev.tail = curr.tail;
					prev.size += curr.size;
				}
			}
			
			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}
		
		private void displayReverseHelper(Node node){ 
			if(node==null) {
				return;
			}
			displayReverseHelper(node.next);
			System.out.print(node.data + " ");
	    }

	    public void displayReverse(){
	      displayReverseHelper(head);
	      System.out.println();
	    }
	    
	    private void reversePRHelper(Node node){
	    	if(node==null) {
	    		return;
	    	}
	    	reversePRHelper(node.next);
	    	if(node==tail) {
	    		// do nothing
	    	}
	    	else {
	    		node.next.next = node;
	    	}
	    }
	    
	    public void reversePR(){
	    	reversePRHelper(head);
	    	head.next = null;
	    	Node temp = head;
	    	head = tail;
	    	tail = temp;
	    }
	    
	    private void reverseDRHelper(Node right, int n){
	    	if(right==null) {
	    		return;
	    	}
	    	
	    	reverseDRHelper(right.next, n+1);
	    	
	    	if(n >= size/2) {
	    		int temp = left.data;
	    		left.data = right.data;
	    		right.data = temp;
	    		
	    		left = left.next;
	    	}
	    	
	    }
	    
	    Node left;
	    public void reverseDR(){
	    	left = head;
	    	reverseDRHelper(head, 0);
	    	
	    }
	    public boolean isPalindromeHelper(Node right) {
	        if(right == null) {
	        	return true;
	        }
	        
	        boolean temp = isPalindromeHelper(right.next);
	        if(temp == false) {
	        	return false;
	        }
	        else if(right.data != pLeft.data) {
	        	return false;
	        }
	        
	        pLeft = pLeft.next;
	        return true;
	    }
	    
	    Node pLeft;
	    public boolean isPalindrome() {
	    	pLeft = head;
	    	return isPalindromeHelper(head);
	    }
	    
	    public void foldHelper(Node right, int n) {
	        if(right == null) {
	        	return;
	        }
	        foldHelper(right.next, n+1);
	        if(n>size/2) {
	        	Node temp = fLeft.next;
	        	fLeft.next = right;
	        	right.next = temp;
	        	fLeft = temp;
	        }
	        else if(n==size/2) {
	        	tail = right;
	        	tail.next = null;
	        }
	        
	      }
	    
	    Node fLeft;
	    public void fold() {
	    	fLeft = head;
	    	foldHelper(head, 0);
	    }
	    
	    // pv=place value of digit
	    public static int carry(Node one, int pv1, Node two, int pv2, LinkedList res) {
	    	if(one==null && two==null) {
	    		return 0;
	    	}
	    	
	    	int data = 0;
	    	if(pv1 > pv2) {
	    		int original_carry = carry(one.next, pv1-1, two, pv2, res);
	    		data = one.data + original_carry;
	    	}
	    	else if(pv1 < pv2) {
	    		int original_carry = carry(one, pv1, two.next, pv2-1, res);
	    		data = two.data + original_carry;
	    	}
	    	else {
	    		int original_carry = carry(one.next, pv1-1, two.next, pv2-1, res);
	    		data = one.data + two.data + original_carry;
	    	}
	    	
	    	int new_data = data%10;
	    	int new_carry = data/10;
	    	res.addFirst(new_data);
	    	return new_carry;
	    }
	    
	    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
	       LinkedList res = new LinkedList();
	       int car = carry(one.head, one.size, two.head, two.size, res);
	       if(car>0) {
	    	   res.addFirst(car);
	       }
	       return res;
	    }
	    
	    public static int findIntersection(LinkedList one, LinkedList two){
	        Node t1 = one.head;
	        Node t2 = two.head;
	        
	        int delta = Math.abs(one.size - two.size);
	        
	        if(one.size > two.size) {
	        	for(int i=0; i<delta; i++) {
	        		t1 = t1.next;
	        	}
	        }
	        else {
	        	for(int i=0; i<delta; i++) {
	        		t2 = t2.next;
	        	}
	        }
	        
	        while(t1 != t2) {
	        	t1 = t1.next;
	        	t2 = t2.next;
	        }
	        
	        return t1.data;
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

        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
          int d = Integer.parseInt(values2[i]);
          l2.addLast(d);
        }

        int li = Integer.parseInt(br.readLine());
        int di = Integer.parseInt(br.readLine());
        if(li == 1){
          Node n = l1.getNodeAt(di);
          l2.tail.next = n;
          l2.tail = l1.tail;
          l2.size += l1.size - di;
        } else {
          Node n = l2.getNodeAt(di);
          l1.tail.next = n;
          l1.tail = l2.tail;
          l1.size += l2.size - di;
        }

        int inter = LinkedList.findIntersection(l1, l2);
        System.out.println(inter);
    }
}