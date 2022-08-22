package com.acdirican.ds.graph;

import org.junit.jupiter.api.Test;

class WeightedUnWeightedDiGraphTest {

	@Test
	void testWeightedDiGraph() {
		var g = GraphReader.readWeighteDiGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		System.out.println(g);
	}

}
