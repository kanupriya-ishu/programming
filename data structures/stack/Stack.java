public class Stack {
	static final int MAX=1000;
	int top;
	int[] s = new int[MAX];
	
	Stack()
	{
		top = -1;
	}
	
	boolean isEmpty(){
		return top==-1;
	}
	
	void push(int x)
	{
		if (top==MAX-1)
		{
			System.out.println("Stack Overflow");
		}
		
		else
		{
			s[++top] = x;
			System.out.println(x+" pushed in stack");
		}
	}
	
	void pop()
	{
		if (isEmpty())
		{
			System.out.println("Stack Underflow");
		}
		else
		{
			System.out.println(s[top]+" is popped");
			top--;
		}
	}
	
	void printStack()
	{
		for(int i=top; i >= 0; i--)
		{
			System.out.println("|"+s[i]+"|");
		}
	}

}
