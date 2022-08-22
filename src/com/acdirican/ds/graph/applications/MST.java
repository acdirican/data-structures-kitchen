package com.acdirican.ds.graph.applications;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.acdirican.ds.graph.GraphReader;
import com.acdirican.ds.graph.WeightedDiGraph;
import com.acdirican.ds.graph.WeightedGraph;
import com.acdirican.ds.graph.abstracts.BaseGraph;
import com.acdirican.ds.graph.abstracts.IWeightedGraph;


public class MST {
	public static List<Integer> prims(IWeightedGraph<Integer> graph, int start) {

		int[] parent = new int[graph.nV()];
		Arrays.fill(parent, -1);

		double[] distance = new double[graph.nV()];
		Arrays.fill(distance, Double.MAX_VALUE);

		distance[start] = 0;

		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(graph.nV());

		for(int i=0; i<graph.nV(); i++) {
			q.add(new Vertex(i, distance));
		}


		while (!q.isEmpty()) {
			
			int u = q.peek().vertex;
	//		System.out.println(u);
			
			for (Vertex ver : q) {
				int v = ver.vertex;
				if ( distance[v] > graph.getWeight(u, v)) {
					
					distance[v] = graph.getWeight(u, v);
					parent[v] = u;
					
					

					
				}
			}
			
			q.poll();
					

			
		}
		
	
		return Arrays.stream(parent).boxed().toList();
		

	}
	
	public static void main(String[] args) {
		WeightedGraph<Integer> graph1 = GraphReader.readWeightedGraph("resources/graphs/digraph5.txt", Integer::parseInt);
		System.out.println(graph1);

            
		System.out.println("path:" +MST.prims(graph1, 0));
	

		int edges[][] = new int[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		var graph2 = new WeightedGraph<Integer>(edges.length);
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				graph2.addEdge(i, j, edges[i][j]);
			}
		}

    		System.out.println("path:" + MST.prims(graph2, 0));
    	
	}
}
