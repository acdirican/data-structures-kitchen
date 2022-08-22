package com.acdirican.ds.graph;

import com.acdirican.ds.graph.abstracts.DiGraph;
import com.acdirican.ds.graph.abstracts.IUnWeightedDiGraph;

public class UnWeightedDiGraph extends DiGraph implements IUnWeightedDiGraph {

	public UnWeightedDiGraph(int nVertices) {
		super(nVertices);
	}

	@Override
	public boolean addEdge(int u, int v) {
		if (hasEdge(u, v)) {
			return false;
		}
		addAdjacent(u, new AdjacentVertex(v));

		return true;
	}
	
}
