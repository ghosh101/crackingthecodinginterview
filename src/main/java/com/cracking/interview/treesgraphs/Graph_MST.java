package com.cracking.interview.treesgraphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_MST {

	static class Vertex{
		private int dest;
		private int weight;

		Vertex(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
	}

	private int V;
	private LinkedList<Vertex> adjList[];

	Graph_MST(int V){
		this.V = V;
		adjList = new LinkedList[V];

		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}


	/*
	 * For the priority queue
	 */
	class Node{
		int key;
		int vertex;
	}

	class comparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o1.key - o2.key;
		}
	}

	public void addEdge(int source, int dest, int weight) {
		Vertex srcvertex = new Vertex(dest, weight);
		this.adjList[source].add(srcvertex);

		Vertex destvertex = new Vertex(source, weight);
		this.adjList[dest].add(destvertex);
	}

	public static void main(String[] args) {
		Graph_MST graph = new Graph_MST(5);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 8);
		graph.addEdge(1, 4, 5);
		graph.addEdge(3, 4, 9);
		graph.addEdge(2, 4, 7);

		int[] parent = mst(graph);
		
		System.out.println("Edge  Weight");
		for(int i = 1; i<graph.V; i++) {
			int par = parent[i];
			Vertex v = graph.adjList[i].stream().filter(vertex -> vertex.dest == par).findFirst().get();
			
			System.out.printf("%d - %d  %d \n", parent[i], i, v.weight);
		}
	}

	private static int[] mst(Graph_MST graph) {
		boolean[] visited = new boolean[graph.V]; //tracks the visited vertices
		int[] parent = new int[graph.V];          //keeps track of the minimum spanning tree
		Node[] e = new Node[graph.V];             //to track the minimum weight at each vertex

		for (int i = 0; i < graph.V; i++) {
			e[i] = graph.new Node();
			e[i].key = Integer.MAX_VALUE;
			e[i].vertex = i;

			parent[i] = -1;
		}

		e[0].key = 0;

		PriorityQueue<Node> queue = new PriorityQueue<>(graph.V, graph.new comparator()); //will reduce the time complexity to O(ElogV)
		for(int i = 0; i<graph.V; i++) {
			queue.offer(e[i]);
		}


		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.vertex] = true;

			List<Vertex> list = graph.adjList[node.vertex];

			for (Vertex vertex : list) {
				if(!visited[vertex.dest]) {
					if(e[vertex.dest].key > vertex.weight) {
						queue.remove(e[vertex.dest]);
						e[vertex.dest].key = vertex.weight;
						queue.offer(e[vertex.dest]);
						
						parent[vertex.dest] = node.vertex;
					}
				}
			}
		}

		return parent;
	}

}
