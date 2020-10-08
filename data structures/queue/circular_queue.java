
public class CircularQueue {
	int front, rear, size;
	int[] queue;
	
	CircularQueue(int n) {
		size = n;
		front = -1;
		rear = -1;
		queue = new int[size];
	}
	
	void enqueue(int value) {
		if (isFull())
		{
			System.out.println("QUEUE IS FULL!");
		}
		
		else
		{
			if(front==-1 && rear==-1)
			{
				front = 0;
				rear = 0;
				queue[rear] = value;
			}
			
			else
			{
				rear = (rear + 1)%size;
				queue[rear] = value;
			}
			
		}
	}
	
	void dequeue() {
		if (isEmpty())
		{
			System.out.println("QUEUE IS EMPTY!");
		}
		
		else if(front==rear)
		{
			front = 0;
			rear = 0;
		}
		else
		{
			front = (front+1)%size;
		}
	}
	
	void printQueue(int queue[])
	{
		 if (isEmpty()) 
	    { 
	        System.out.println("Queue is Empty"); 
	        return;
	    } 
		 
	    System.out.println("Elements in Circular Queue are: "); 
	    if (rear >= front) 
	    { 
	        for (int i = front; i <= rear; i++) 
	            System.out.print(queue[i] + " "); 
	    } 
	    else
	    { 
	        for (int i = front; i < size; i++) 
	            System.out.print(queue[i]+" "); 
	  
	        for (int i = 0; i <= rear; i++) 
	        	System.out.print(queue[i]+" ");  
	    } 
	}
	
	boolean isFull()
	{
		if (front==(rear+1)%size )
		{
			return true;
		}
		
		return false;
	}
	
	boolean isEmpty()
	{
		if (front==-1)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue q = new CircularQueue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		q.enqueue(110);
		q.dequeue();
		q.enqueue(120);
		q.printQueue(q.queue);
	}
}