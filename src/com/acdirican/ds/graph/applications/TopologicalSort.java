package com.acdirican.ds.graph.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.acdirican.ds.graph.abstracts.BaseGraph;
import com.acdirican.ds.graph.abstracts.IDiGraph;


/**
 * Topological sort is an ordering of vertices in an acyclic digraph (DAG) such that
 * if there is a path from vi to vj , then vj appears after vi in the ordering.
 * 
 * • Example: course prerequisite requirements.
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class TopologicalSort {
	public static List<Integer> sortByDFS(IDiGraph graph) {
		int V = graph.nV();
		char[] visited = new char[V];
		Arrays.fill(visited, 'n');
		Deque<Integer> queue = new LinkedList<>(); 

		for (int u = 0; u < V; u++) {
			if (visited[u] == 'n') {
				sortByDFSHelper(graph, u, visited, queue);
			}
		}
		List<Integer> sorted = queue.stream().toList();
		return sorted;
	}

	private static void sortByDFSHelper(IDiGraph graph, int u, char[] visited, Deque<Integer> queue) {
		if (visited[u] == 'p') {
			throw new RuntimeException("The graph has a cycle!");
		}
		if (visited[u] == 'v') {
			return;
		}
		
		visited[u] = 'p';
		for (int v : graph.adjacents(u)) {
			sortByDFSHelper(graph, v, visited, queue);
		}
		visited[u] = 'v';
		queue.addFirst(u);
	}

	/**
	 * Rule: A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0. 
	 * Algorith: 
	 * @param graph
	 * @return
	 */
	public static List<Integer> sortKahn(IDiGraph graph) {
		Map<Integer, Integer> inDegrees = graph.inDegreeAll();
		List<Integer> sorted =  new ArrayList<>();
		Queue<Integer> process =  inDegrees.entrySet()
				.stream()
				.filter(e->e.getValue()==0)
				.map(e->e.getKey())
				.collect(Collectors.toCollection(LinkedList::new));
		
	
		while(!process.isEmpty()){
			
			int u = process.poll();
			sorted.add(u);
					
			List<Integer> adjacents = graph.adjacents(u);
			adjacents.forEach(v-> {
				int d = inDegrees.getOrDefault(v, -1);
				if (d>=0) {
					inDegrees.replace(v,  d-1);
					if (d-1==0) {
						process.add(v);
					}
				}
			});
		}
		if (sorted.size() != graph.nV()) {
			throw new RuntimeException("The graph is cyclic.");
		}
		return sorted;
	}
	
}
