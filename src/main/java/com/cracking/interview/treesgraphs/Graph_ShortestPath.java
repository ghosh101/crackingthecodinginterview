package com.cracking.interview.treesgraphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_ShortestPath {

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
	
	Graph_ShortestPath(int V){
		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	/*
	 * For priority queue implementation
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
		Vertex sourceVertex = new Vertex(dest, weight);
		this.adjList[source].add(sourceVertex);
		
		Vertex destVertex = new Vertex(source, weight);
		this.adjList[dest].add(destVertex);
	}
	
	public static void main(String[] args) {
		Graph_ShortestPath graph = new Graph_ShortestPath(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(1, 2, 8);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 9);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(7, 8, 7);
		graph.addEdge(6, 8, 6);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 5, 14);
		
		int v = 8;
		Node[] e = shortestPath(graph, v);
		System.out.println("Shortest path between:");
		for (int i = 0; i < e.length; i++) {
			System.out.printf("%d  -  %d : %d\n", v, i, e[i].key);
		}
	}

	private static Node[] shortestPath(Graph_ShortestPath graph, int v) {
		boolean[] visited = new boolean[graph.V]; //track the visited vertices
		Node[] e = new Node[graph.V];             //keeps the distance from the given vertex in its key attribute
		
		for(int i=0; i<graph.V; i++) {
			e[i] = graph.new Node();
			
			e[i].vertex = i;
			e[i].key = Integer.MAX_VALUE;
		}
		
		e[v].key = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>(graph.V, graph.new comparator());
		for(int i=0; i<graph.V; i++) {
			queue.add(e[i]);
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(!visited[node.vertex]) {
				visited[node.vertex] = true;
				
				List<Vertex> list = graph.adjList[node.vertex];
				for (Vertex vertex : list) {
					if(e[vertex.dest].key > vertex.weight + node.key) {
						queue.remove(e[vertex.dest]);
						e[vertex.dest].key = vertex.weight + node.key;
						queue.offer(e[vertex.dest]);
					}
				}
			}
		}
		
		return e;
	}

}
