package com.acdirican.ds.graph.applications;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.acdirican.ds.graph.GraphReader;
import com.acdirican.ds.graph.WeightedDiGraph;
import com.acdirican.ds.graph.WeightedGraph;

class TopologicalSortTest {

	static WeightedDiGraph<Integer> diGraph1 = null;
	static WeightedDiGraph<Integer> diGraph1Cyclic;
	@BeforeAll
	static void setupAll() {
		diGraph1 = GraphReader.readWeighteDiGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		diGraph1Cyclic = GraphReader.readWeighteDiGraph("resources/graphs/digraph1Cycle.txt", Integer::parseInt);
	}
	
	@Test
	void test() {
		List<Integer> result1 = TopologicalSort.sortByDFS(diGraph1);
		System.out.println(result1);
		assertEquals(List.of(5, 2, 3, 4, 1, 0, 6, 8, 7), result1);
		
		
		List<Integer> result2 = TopologicalSort.sortKahn(diGraph1);
		System.out.println(result2);
		assertEquals(List.of(5, 2, 3, 4, 1, 0, 7, 6, 8), result2);
		
		
		
		assertThrows(RuntimeException.class, ()->TopologicalSort.sortKahn(diGraph1Cyclic));
		assertThrows(RuntimeException.class, ()->TopologicalSort.sortByDFS(diGraph1Cyclic));
		
	}

}
