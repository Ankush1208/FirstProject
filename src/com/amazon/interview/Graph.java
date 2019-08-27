package com.amazon.interview;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> list[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}

	private static void addEdge(Graph g1, int u, int v) {

		g1.list[u].addFirst(v);
		g1.list[v].addFirst(u);
	}

	private static void printGraph(Graph g1) {
		for (int i = 0; i < g1.v; i++) {
			System.out.println("the vertex: " + i);
			System.out.print("head");
			for (Integer pCrawl : g1.list[i]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void main(String... a) {
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		printGraph(graph);

	}

}
