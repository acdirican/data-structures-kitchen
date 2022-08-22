package com.acdirican.ds.graph;

import org.junit.jupiter.api.Test;

class UnWeightedDiGraphTest {

	@Test
	void testUnWeightedDiGraph() {
		var g = GraphReader.readUnWeightedDiGraph("resources/graphs/digraph1.txt");
		System.out.println(g);
	}

}
