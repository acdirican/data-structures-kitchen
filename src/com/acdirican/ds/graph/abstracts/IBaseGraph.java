package com.acdirican.ds.graph.abstracts;

import java.util.List;

public interface IBaseGraph {
	
	public boolean isComplete();
	boolean removeEdge(int u, int v);
	boolean isConnected();
	boolean isCyclic();
	boolean hasEdge(int u, int v);
	IAdjacentVertex getAdjacentVertex(int u, int v);
	List<IAdjacentVertex> adjacentVertexes(int u);
	List<Integer> adjacents(int u);
	public int nV();

}
