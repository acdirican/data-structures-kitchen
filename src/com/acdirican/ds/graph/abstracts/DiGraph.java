package com.acdirican.ds.graph.abstracts;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class DiGraph extends BaseGraph implements IDiGraph{

	public DiGraph(int nVertices) {
		super(nVertices);
	}

	@Override
	public boolean removeEdge(int u, int v) {
		return removeAdjacent(u, getAdjacentVertex(u, v));
	}

	@Override
	public boolean hasEdge(int u, int v) {
		return hasAdjacent(u,getAdjacentVertex(u, v));
	}

	@Override
	public int inDegree(int u) {
		return (int) adj.stream()
						.mapToLong(l->l.stream()
								.filter(a->a.getAdjacent() == u)
								.count())
						.sum();
	}

	@Override
	public int outDegree(int u) {
		return adj.get(u).size();
	}

	@Override
	public Map<Integer, Integer> inDegreeAll() {
		return IntStream.range(0, nV()).boxed().collect(Collectors.toMap(i->i, this::inDegree));
	}

	@Override
	public Map<Integer, Integer> outDegreeAll() {
		return IntStream.range(0, nV()).boxed().collect(Collectors.toMap(i->i, this::outDegree));
	}


	
}
