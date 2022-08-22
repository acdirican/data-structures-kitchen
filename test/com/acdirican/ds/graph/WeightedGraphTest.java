package com.acdirican.ds.graph;

import org.junit.jupiter.api.Test;

class WeightedGraphTest {

	@Test
	void test() {
		var g = GraphReader.readWeightedGraph("resources/graphs/digraph1.txt", Integer::parseInt);
		System.out.println(g);
	}

}
