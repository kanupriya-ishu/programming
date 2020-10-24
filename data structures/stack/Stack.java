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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		System.out.println("Choose: \n1. push \n2.pop \n3.print stack");
		int choice = sc.nextInt();
		while(choice < 4)
		{
			switch(choice)
			{
			case 1:
				System.out.println("Enter number to push:");
				int x = sc.nextInt();
				s.push(x);
				break;
			case 2:
				s.pop();
				break;
			case 3:
				s.printStack();
				break;
			default:
				System.out.println("Please enter a valid input");
			}
			
			System.out.println("Choose: \n1. push \n2.pop \n3.print stack");
			choice = sc.nextInt();
		}
		sc.close();
	
	}
	
}
