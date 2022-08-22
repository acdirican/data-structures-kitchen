package com.acdirican.ds.graph;

import com.acdirican.ds.graph.abstracts.Graph;
import com.acdirican.ds.graph.abstracts.IUnWeightedGraph;

public class UnWeightedGraph extends Graph implements IUnWeightedGraph{

	public UnWeightedGraph(int nVertices) {
		super(nVertices);
	}

	@Override
	public boolean addEdge(int u, int v) {
		if (hasEdge(u, v)) {
			return false;
		}
		addAdjacent(u, new AdjacentVertex(v));
		addAdjacent(v, new AdjacentVertex(u));
		return true;
	}
	

}
