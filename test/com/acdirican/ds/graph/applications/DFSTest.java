package com.acdirican.ds.graph.applications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.acdirican.ds.graph.GraphReader;
import com.acdirican.ds.graph.WeightedDiGraph;
import com.acdirican.ds.graph.WeightedGraph;
import com.acdirican.ds.graph.abstracts.BaseGraph;

class DFSTest {
	static WeightedGraph<Integer> graph = null;
	static WeightedDiGraph<Integer> diGraph = null;
	static WeightedDiGraph<Integer> diGraph1Cyclic;
	@BeforeAll
	static void setupAll() {
		graph = GraphReader.readWeightedGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		diGraph = GraphReader.readWeighteDiGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		diGraph1Cyclic = GraphReader.readWeighteDiGraph("resources/graphs/digraph1Cycle.txt", Integer::parseInt);
		System.out.println(graph);
	}
	
	@Test
	void testDfsPrint() {
		DFS.dfsPrint(graph, 0);
	}
	
	@Test
	void testPath() {
		List<Integer> path = DFS.path(graph, 0, 4);
		assertEquals(List.of(0,5,2,3,1,4), path);
	}
	
	
	/*
	@Test
	void testAllPath() {
		List<List<Integer>> allPaths = DFS.allPaths(graph, 0);
		System.out.println(allPaths);
		assertEquals(List.of(List.of(0,5,2,3), List.of(0,1,4)), allPaths);
	}
	
	*/
	
	@Test
	void testAllPathDirected() {
		List<List<Integer>> allPaths = DFS.allPaths(diGraph, 0);
		System.out.println(allPaths);
		assertEquals(List.of(List.of(0,7), List.of(0,6,8)), allPaths);
	}
	
	@Test
	void testCyclic() {
		assertEquals(false, DFS.isCyclic(diGraph));
		assertEquals(true, DFS.isCyclic(diGraph1Cyclic));
	}
}
