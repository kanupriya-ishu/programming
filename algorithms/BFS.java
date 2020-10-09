import java.util.*;
public class BFS {
	int V; // number of vertices in graph
	LinkedList<Integer> adj[]; // create adjacency list for graph representation
	
	
	public BFS(int v) {
		// TODO Auto-generated constructor stub
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	// Add edge in graph 
	void addEdge(int v, int u)
	{
		adj[v].add(u);
	}
	
	// BFS traversal 
	void BFS_cal(int start)
	{
		boolean[] visited = new boolean[V];
		
		// queue for BFS using linked list
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// starting node is visited hence marked true
		visited[start] = true;
		queue.add(start);
		
		while (queue.size() != 0)
		{
			// dequeue vertex from queue
			start = queue.poll();
			// print the vertex
			System.out.print(start+" ");
			
			Iterator<Integer> i = adj[start].listIterator();
			
			while(i.hasNext())
			{
				int next = i.next();
				if (visited[next]==false)
				{
					visited[next]=true;
					queue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of vertices");
		int n = sc.nextInt();
		
		BFS b = new BFS(n);
		
		System.out.println("Enter -1 to exit.");
		int edgeFrom=0, edgeTo;
		
		while(edgeFrom!=-1)
		{
			System.out.println("Enter edge from vertex: ");
			edgeFrom = sc.nextInt();
			if(edgeFrom!=-1)
			{
				System.out.println("Enter edge to vertex: ");
				edgeTo = sc.nextInt();
				b.addEdge(edgeFrom, edgeTo);
			}
		}
		
		System.out.println("Enter starting vertex");
		int start = sc.nextInt();
        sc.close();
        b.BFS_cal(start); 
	}

}
