package com.acdirican.ds.graph.applications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.acdirican.ds.graph.GraphReader;
import com.acdirican.ds.graph.UnWeightedGraph;
import com.acdirican.ds.graph.WeightedDiGraph;
import com.acdirican.ds.graph.WeightedGraph;
import com.acdirican.ds.graph.abstracts.BaseGraph;

class BFSTest {
	static UnWeightedGraph unweightedGraph = null;
	static WeightedGraph<Integer>  wieghtedGraph = null;
	static WeightedDiGraph<Integer> diGraph = null;
	static WeightedDiGraph<Object> diGraphCyclic = null;
	
	@BeforeAll
	static void setupAll() {
		unweightedGraph = GraphReader.readGraph("resources/graphs/digraph0.txt");
		wieghtedGraph = GraphReader.readWeightedGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		
		diGraph = GraphReader.readWeighteDiGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		diGraphCyclic = GraphReader.readWeighteDiGraph("resources/graphs/digraph1Cycle.txt", Integer::parseInt);

	}
	
	@Test
	void testBfsPrint() {
		BFS.bfsPrint(diGraph, 4);
		BFS.bfsPrintUsinVertexColor(diGraph, 4);;
	}

	
	
	@Test
	void testCyclic() {
		assertEquals(false, BFS.isCyclic(unweightedGraph));
		assertEquals(true, BFS.isCyclic(wieghtedGraph));
		
		assertEquals(false, BFS.isCyclic(diGraph));
		assertEquals(true, BFS.isCyclic(diGraphCyclic));
	}
	
	@Test
	void testPaths() {
		System.out.println(BFS.paths(unweightedGraph, 0));
	}
}
