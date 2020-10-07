/*
	In this program, I have implemented Bredth First Search (BFS) algorithm using queue. 
	Here queue is implemented with linked list.
*/

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
	void BFS(int start)
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
		BFS b = new BFS(4);
		
		b.addEdge(0, 1); 
        b.addEdge(0, 2); 
        b.addEdge(1, 2); 
        b.addEdge(2, 0); 
        b.addEdge(2, 3); 
        b.addEdge(3, 3); 
        
        b.BFS(2); 
	}

}
