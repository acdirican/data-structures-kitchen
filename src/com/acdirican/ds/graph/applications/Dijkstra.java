package com.acdirican.ds.graph.applications;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.acdirican.ds.graph.GraphReader;
import com.acdirican.ds.graph.WeightedDiGraph;
import com.acdirican.ds.graph.abstracts.BaseGraph;
import com.acdirican.ds.graph.abstracts.IDiGraph;
import com.acdirican.ds.graph.abstracts.IWeightedDiGraph;

/**
 * Dijkstra’s algorithm solves the SSSP problem on a weighted digraph G=(V,E)
 * assuming no negative weights exist in G
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class Dijkstra {
	public static List<Integer> sorthestPath(IWeightedDiGraph<Double> graph, int start, int finish) {

		int[] parent = new int[graph.nV()];
		Arrays.fill(parent, -1);

		double[] distance = new double[graph.nV()];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;

		boolean[] included = new boolean[graph.nV()];

		int u = start;
		while (u != -1) {
		//	System.out.println(u);
			included[u] = true;

			for (Integer v : graph.adjacents(u)) {
				if (!included[v]) {
					if (distance[v] > distance[u] + graph.getWeight(u, v)) {
						distance[v] = distance[u] + graph.getWeight(u, v);
						parent[v] = u;
					}
				}
			}
			//System.out.println(u + " -> " + Arrays.toString(included) + " | " + Arrays.toString(parent) + " | " + Arrays.toString(distance));
			u = closest(graph, included, distance);
		}

	//	System.out.println(Arrays.toString(parent));
		Deque<Integer> path = new LinkedList<>();
		u = finish;
		while (u != -1) {
			path.addFirst(u);
			u = parent[u];
		}
		return path.stream().toList();

	}

	private static int closest(IWeightedDiGraph<Double> graph, boolean[] included, double[] distance) {
		int c = -1;
		for (int u = 0; u < graph.nV(); u++) {
			if (included[u]) {
				for (Integer v : graph.adjacents(u)) {
					if (!included[v]) {
						if (c == -1 || distance[v] < distance[c]) {
							c = v;
						}
					}
				}
			}
		}

		return c;
	}

	public static List<Integer> sorthestPathPrioritQueue(IWeightedDiGraph<Double> graph, int start, int finish) {

		int[] parent = new int[graph.nV()];
		Arrays.fill(parent, -1);

		double[] distance = new double[graph.nV()];
		Arrays.fill(distance, 100);

		distance[start] = 0;

		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(graph.nV());

		q.add(new Vertex(start, distance));


		while (!q.isEmpty()) {
			
			int u = q.poll().vertex;
	//		System.out.println(u);
			
			for (Integer v : graph.adjacents(u)) {
				if ( distance[v] > distance[u] + graph.getWeight(u, v)) {
					
					distance[v] = distance[u] + graph.getWeight(u, v);
					parent[v] = u;
					Vertex v1 = new Vertex(v, distance);
					q.add(v1);

					
				}
			}
					

			
		}
		
	//	System.out.println(Arrays.toString(parent));
		Deque<Integer> path = new LinkedList<>();
		int u = finish;
		while (u != -1) {
			path.addFirst(u);
			u = parent[u];
		}
		return path.stream().toList();


	}

	public static void main(String[] args) {
		var graph1 = GraphReader.readWeighteDiGraph("resources/graphs/digraph5.txt", Double::parseDouble);
		System.out.println(graph1);

		System.out.println("path:" + Dijkstra.sorthestPath(graph1, 0, 5));
		System.out.println("path:" + Dijkstra.sorthestPathPrioritQueue(graph1, 0, 5));

		double edges[][] = new double[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		var graph2 = new WeightedDiGraph<Double>(edges.length);
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				graph2.addEdge(i, j, edges[i][j]);
			}
		}
		System.out.println("path:" + Dijkstra.sorthestPath(graph2, 0, 8));
		System.out.println("path:" + Dijkstra.sorthestPathPrioritQueue(graph2, 0, 8));
	}
}
