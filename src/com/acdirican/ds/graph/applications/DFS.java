package com.acdirican.ds.graph.applications;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.acdirican.ds.graph.abstracts.BaseGraph;
import com.acdirican.ds.graph.abstracts.IBaseGraph;

/**
 * Cycle detection, Topological sort,
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class DFS {
	public static void dfsPrint(IBaseGraph graph, int start) {
		dfsPrintHelper(graph, start, new boolean[graph.nV()]);
		System.out.println();
	}

	private static void dfsPrintHelper(IBaseGraph graph, int u, boolean[] visited) {
		if (visited[u]) {
			return;
		}
		System.out.print(u + "->");
		visited[u] = true;
		List<Integer> neighbors = graph.adjacents(u);
		neighbors.forEach(v->dfsPrintHelper(graph, v, visited));
	}
	
	public static List<Integer> path(BaseGraph graph, int start, int finish) {
		return pathHelper(graph, start, finish, new boolean[graph.nV()]);
	}
	
	private static LinkedList<Integer> pathHelper(IBaseGraph graph, int start, int finish, boolean[] visited) {
		if (visited[start]) {
			return null;
		}
		
		if (start == finish) {
			LinkedList<Integer> p = new LinkedList<>();
			p.add(finish);
			return p;
		}
		visited[start] = true;
		LinkedList<Integer> p =  null;
		for (Integer v : graph.adjacents(start)) {
			p = pathHelper(graph, v, finish, visited);
			if (p!=null) {
				p.addFirst(start);
				break;
			}
		}
		return p;
	}
	
	public static List<List<Integer>> allPaths(IBaseGraph graph, int start) {
		List<List<Integer>> allPaths = new ArrayList<>();
		allPathsHelper(graph, start, start, allPaths, new LinkedList<Integer>(),  new boolean[graph.nV()]);
		return allPaths;
	}
	
	private static void allPathsHelper(IBaseGraph graph, int start, int u, List<List<Integer>> allPaths
			, LinkedList<Integer> path, boolean[] visited) {

		if (visited[u]) {
			allPaths.add(new ArrayList<>(path));
			return;
		}
				
		visited[u] = true;
		
		path.add(u);
		
		if ( graph.adjacents(u).size() == 0) {
			allPaths.add(new ArrayList<>(path));
			path.removeLast();
			return;
		}
		
		for (Integer v : graph.adjacents(u)) {
			allPathsHelper(graph, start, v, allPaths, path, visited);
		}
		
		
		path.removeLast();

	}
	
	public static boolean isCyclic(IBaseGraph graph) {
		//color:
			//color == 0 -> unvisited, not in a path,
			//color == 1 -> visited, not in current path
			//color == 2 -> visited, in path
 		int[] color = new int[graph.nV()]; 
		for (int u = 0; u < graph.nV(); u++) {
			if (color[u] == 0) {
				if (isCyclicHelper(graph, u, u, color)) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isCyclicHelper(IBaseGraph graph, int start, int u, int[] color) {
		if (color[u] == 2) {
			return true;
		}
		
		if (color[u] == 1) {
			return false;
		}
		color[u] = 2;
		List<Integer> neighs = graph.adjacents(u);
		for (Integer v : neighs) {
			if (isCyclicHelper(graph, start, v, color)) {
				return true;
			}
		}
		color[u] = 1;
		return false;
	}


}
