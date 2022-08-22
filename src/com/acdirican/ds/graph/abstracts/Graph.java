package com.acdirican.ds.graph.abstracts;

public abstract class Graph extends BaseGraph {

	public Graph(int nVertices) {
		super(nVertices);
	}
	

	public boolean removeEdge(int u, int v) {
		return removeAdjacent(u, getAdjacentVertex(u, v)) && removeAdjacent(v, getAdjacentVertex(v, u));
	}

	@Override
	public boolean hasEdge(int u, int v) {
		return hasAdjacent(u, getAdjacentVertex(u, v)) && hasAdjacent(v, getAdjacentVertex(v, u));
	}

}
