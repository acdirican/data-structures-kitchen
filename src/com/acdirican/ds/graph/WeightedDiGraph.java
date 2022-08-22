package com.acdirican.ds.graph;

import com.acdirican.ds.graph.abstracts.DiGraph;
import com.acdirican.ds.graph.abstracts.IWeightedAdjacentVertex;
import com.acdirican.ds.graph.abstracts.IWeightedDiGraph;

public class WeightedDiGraph<T> extends DiGraph implements IWeightedDiGraph<T> {

	public WeightedDiGraph(int nVertices) {
		super(nVertices);
	}

	@Override
	public boolean addEdge(int u, int v, T weight) {
		if (hasEdge(u, v)) {
			return false;
		}
		addAdjacent(u, new WeightedAdjacentVertex<T>(v, weight));
		return true;
	}


	@Override
	public IWeightedAdjacentVertex<T> getAdjacentVertex(int u, int v) {
		var vertex = super.getAdjacentVertex(u, v);
		return vertex!=null 
				? (IWeightedAdjacentVertex<T>) super.getAdjacentVertex(u, v)
				: null;
	}
	@Override
	public T getWeight(int u, int v) {
		return getAdjacentVertex(u, v).getWeight();
	}
	
	



	
	
}
