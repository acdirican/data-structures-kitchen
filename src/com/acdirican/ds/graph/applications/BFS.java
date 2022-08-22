package com.acdirican.ds.graph.applications;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.acdirican.ds.graph.abstracts.BaseGraph;
import com.acdirican.ds.graph.abstracts.Graph;
import com.acdirican.ds.graph.abstracts.IBaseGraph;
import com.acdirican.ds.graph.abstracts.IDiGraph;
import com.acdirican.ds.graph.abstracts.IGraph;

/**
 * Given a graph, G , and a source vertex, s , breadth first search (BFS) checks
 * to discover every vertex reachable from s . 
 * 
 * • BFS discovers vertices reachable from s in a breadth first manner.
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class BFS {
	public static void bfsPrint(BaseGraph graph, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> outOfQueue = new LinkedList<>();
		
		queue.add(start);
		
		while (!queue.isEmpty()) {
			//Extract the next 
			int u = queue.poll();
			
			outOfQueue.add(u);
			System.out.print(u + "->");
			graph.adjacents(u).forEach(v -> {
				if (!outOfQueue.contains(v) && !queue.contains(v)) {
					queue.add(v);
				}
			});
		}
		System.out.println();
	}
	
	public static void bfsPrintUsinVertexColor(BaseGraph graph, int start) {
		Queue<Integer> queue = new LinkedList<>();
		char[] color = new char[graph.nV()]; 
		Arrays.fill(color, 'n'); //'n'->not in queue,  q->in queue, o->left queue
		queue.add(start);
		color[start] = 'q';
		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + "->");
			graph.adjacents(u).forEach(v -> {
				if (color[v] == 'n') {
					queue.add(v);
					color[v] = 'q';
				}
			});
			color[u] = 'o';
		}
		System.out.println();
	}

	public static Map<Integer, List<Integer>> paths(IGraph graph, int start){

		int[] parent = new int[graph.nV()];
		Arrays.fill(parent, -1);
		
		int[] dist= new int[graph.nV()];
		Arrays.fill(dist, -1);
		
		Queue<Integer> process = new LinkedList<>();
		char[] color = new char[graph.nV()]; 
		Arrays.fill(color, 'n'); //'n'->not in queue,  q->in queue, o->left queue
		
		process.add(start);
		color[start] = 'q';
		
		while (!process.isEmpty()) {
			int u = process.poll();
			graph.adjacents(u).forEach(v -> {
				if (color[v] == 'n') {
					process.add(v);
					color[v] = 'q';
					parent[v] = u;
					dist[v] = dist[u]+1;
				}
			});
			color[u] = 'o';
		}
		
		Map<Integer, List<Integer>> result =  new HashMap<>();
		IntStream.range(0, graph.nV()).forEach(i->{
			int s = i;
			LinkedList<Integer> path =  new LinkedList<>();
			if (dist[s]>=0) {
					while(s != -1) {
				path.addFirst(s);
				s = parent[s];
			}
			}
		
			result.put(i, path);
		});
		return result;
	}
	


	public static boolean isCyclic(IBaseGraph graph) {
		
		if(graph instanceof IDiGraph){
			return isCyclicDirectedHelper((IDiGraph) graph);
		}
		return isCyclicUndirectedHelper(graph);
	}

	private static boolean isCyclicUndirectedHelper(IBaseGraph graph) {
		Queue<Integer> queue = new LinkedList<>();
		
		char[] color = new char[graph.nV()]; 
		Arrays.fill(color, 'n'); //'n'->not in queue,  q->in queue, o->left queue
		
		int[] parent = new int[graph.nV()]; 
		Arrays.fill(parent, -1);
		
		queue.add(0);
		color[0] = 'q';
		
		while (!queue.isEmpty()) {
			
			int u = queue.poll();
			for(var v : graph.adjacents(u)) {
				if (color[v] == 'n') {
					parent[v] = u;
					queue.add(v);
					color[v] = 'q';
				}
				else if (parent[u] != v){
					return true;
				}
			}
			color[u] = 'o';
		}
		return false;
	}

	private static boolean isCyclicDirectedHelper(IDiGraph graph) {
		Map<Integer, Integer> inDegrees = graph.inDegreeAll();
		Queue<Integer> process = inDegrees.entrySet()
					.stream()
					.filter(e->e.getValue() == 0)
					.map(e->e.getKey())
					.collect(Collectors.toCollection(LinkedList::new));
		int reached = 0;
		while(!process.isEmpty()) {
			int u = process.poll();
			reached++;
			graph.adjacents(u).forEach(v->{
				int d = inDegrees.getOrDefault(v, -1);
				if (d>=0) {
					inDegrees.replace(v, d-1);
					if (d-1 == 0) {
						process.add(v);
					}
				}
			});
		}
		return reached != graph.nV();
	}

	

	
}
