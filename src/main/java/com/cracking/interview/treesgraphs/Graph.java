package com.cracking.interview.treesgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * Graph representation using an array
 * Find the BFS and DFS
 */
public class Graph {

	static class Vertex{
		int dest;
		int weight;

		Vertex(int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
	}

	int V; //number of vertices in the graph
	LinkedList<Vertex> adjLists[]; //adjacency list

	Graph(int V){ //initialize graph with number of vertices
		this.V = V;
		this.adjLists = new LinkedList[V]; 

		for(int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new LinkedList<>();
		}
	}

	/*
	 * Takes constant time O(1)
	 */
	public void addEdge(int source, int dest, int weight) {
		LinkedList<Vertex> sourceVertexList = this.adjLists[source];
		Vertex destVertex = new Vertex(dest, weight);
		sourceVertexList.add(destVertex);

		//Comment below portion to make it a directed graph
		LinkedList<Vertex> destVertexList = this.adjLists[dest];
		Vertex srcVertex = new Vertex(source, weight);
		destVertexList.add(srcVertex);
	}

	/*
	 * Traverses the source and destination lists. O(M) time, where M is the size of the vertexList
	 */
	public void removeEdge(int source, int dest) {
		LinkedList<Vertex> sourceVertexList = this.adjLists[source];
		for (int i = 0; i < sourceVertexList.size(); i++) {
			if(sourceVertexList.get(i).dest == dest) {
				sourceVertexList.remove(i);
			}
		}

		LinkedList<Vertex> destVertexList = this.adjLists[dest];
		for (int i = 0; i < destVertexList.size(); i++) {
			if(destVertexList.get(i).dest == dest) {
				destVertexList.remove(i);
			}
		}
	}

	/*
	 * Traverses the source list. O(M) time, where M is the size of the sourceVertexList
	 */
	public boolean hasEdge(int source, int dest) {
		LinkedList<Vertex> sourceVertexList = this.adjLists[source];
		for (int i = 0; i < sourceVertexList.size(); i++) {
			if(sourceVertexList.get(i).dest == dest) {
				return true;
			}
		}
		return false;
	}


	/*
	 * Takes constant time O(1)
	 */
	public List<Vertex> outEdges(int source){
		return this.adjLists[source];
	}

	public static void main(String[] args) {
		Graph graph = new Graph (6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 4, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(5, 4, 1);
		graph.addEdge(5, 3, 1);

		bfs(graph, 0);
		System.out.println();
		dfs(graph);
		System.out.println();
		topologicalSort(graph);
		System.out.println();
		
		checkCycleUndirected(graph);
	}

	/*
	 * Can be done using DFS.
	 * We need to send the parent node in recursion, so it should not traverse in the direction of parent node
	 * If a node already present in the adjList is encountered, there exists a cycle
	 */
	private static void checkCycleUndirected(Graph graph) {
		Set<Integer> visited = new HashSet<>();
		int parent = -1;
		int v = 0;
		
		boolean check = checkUndirectedCycleUtil(graph, visited, parent, v);
		System.out.println(check);
	}

	private static boolean checkUndirectedCycleUtil(Graph graph, Set<Integer> visited, int parent, int v) {
		visited.add(v);
		
		List<Vertex> list = graph.adjLists[v];
		for (Vertex vertex : list) {
			if(vertex.dest == parent) continue;
			if(visited.contains(vertex.dest)) {
				return true;
			}else {
				return checkUndirectedCycleUtil(graph, visited, v, vertex.dest);
			}
		}
		return false;
	}

	/*
	 * Topological Sort is applicable only for Directed Acyclic Graphs
	 */
	private static void topologicalSort(Graph graph) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < graph.adjLists.length; i++) {
			if(!visited.contains(i)) {
				topSortUtil(graph, i, visited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	private static void topSortUtil(Graph graph, int i, Set<Integer> visited, Stack<Integer> stack) {
		visited.add(i);
		
		List<Vertex> list = graph.adjLists[i];
		for (Vertex vertex : list) {
			if(!visited.contains(vertex.dest)) {
				topSortUtil(graph, vertex.dest, visited, stack);
			}
		}
		stack.push(i);
	}

	private static void dfs(Graph graph) {
		Set<Integer> visited = new HashSet<>();
		
		for(int i = 0; i < graph.adjLists.length; i++) {
			if(!visited.contains(i)) {
				dfsUtil(graph, i, visited);
			}
		}
	}

	private static void dfsUtil(Graph graph, int i, Set<Integer> visited) {
		visited.add(i);
		System.out.print(i);
		
		List<Vertex> list = graph.adjLists[i];
		for (Vertex vertex : list) {
			if(!visited.contains(vertex.dest)) {
				dfsUtil(graph, vertex.dest, visited);
			}
		}
	}

	private static void bfs(Graph graph, int vertice) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> visitingQue = new LinkedList<>();

		visitingQue.offer(vertice);

		while(!visitingQue.isEmpty()) {
			Integer vertex = visitingQue.poll();

			if(!visited.contains(vertex)) {
				visited.add(vertex);
				System.out.print(vertex);
				LinkedList<Vertex> list = graph.adjLists[vertex];

				for (Vertex vertex2 : list) {
					visitingQue.offer(vertex2.dest);
				}
			}
		}
		return;
	}

}
