package com.acdirican.ds.graph.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Abstract graph with common attributes and methods
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public abstract class BaseGraph implements IBaseGraph {
	protected int nVertices;
	protected List<List<IAdjacentVertex>> adj;

	public BaseGraph(int nVertices) {
		this.nVertices = nVertices;
		this.adj = new ArrayList<>();
		IntStream.range(0, nVertices).forEach(i->adj.add(new ArrayList<>()));
	}

	public boolean isComplete() {
		throw new RuntimeException("Not Implemented Yet");
	}

	@Override
	public IAdjacentVertex getAdjacentVertex(int u, int v) {
		if (u < 0 || u >= adj.size()) {
			return null;
		}
		return adjacentVertexes(u).stream().filter(a -> a.getAdjacent() == v).findAny().orElse(null);
	}

	@Override
	public List<IAdjacentVertex> adjacentVertexes(int u) {
		if (u < 0 || u >= adj.size()) {
			return null;
		}
		return adj.get(u);
	}
	
	@Override
	public List<Integer> adjacents(int u) {
		var vertexes = adjacentVertexes(u);
		return vertexes != null 
				? vertexes.stream().map(IAdjacentVertex::getAdjacent).toList()
				: null;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	public int nV() {
		return nVertices;
	}

	@Override
	public String toString() {
		return adj.stream().map(row -> row.toString()).collect(Collectors.joining("\n"));
	}

	protected void addAdjacent(int u, IAdjacentVertex vertex) {
		if (vertex == null) {
			return;
		}
		adj.get(u).add(vertex);		
	}
	
	protected boolean hasAdjacent(int u, IAdjacentVertex vertex) {
		if (vertex == null) {
			return false;
		}
		return adj.get(u).contains(vertex);		
	}
	

	protected boolean removeAdjacent(int u, IAdjacentVertex vertex) {
		if (vertex == null) {
			return false;
		}
		return adj.get(u).remove(vertex);
	}


	
}
