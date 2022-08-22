package com.acdirican.ds.graph;

import com.acdirican.ds.graph.abstracts.Graph;
import com.acdirican.ds.graph.abstracts.IWeightedAdjacentVertex;
import com.acdirican.ds.graph.abstracts.IWeightedGraph;

/**
 * Weighted undirected graph
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class WeightedGraph<T> extends Graph implements IWeightedGraph<T> {

	public WeightedGraph(int nVertices) {
		super(nVertices);
	}
	
	public WeightedGraph(T[][] edges) {
		super(edges.length);
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (edges[i][j] != null) {
					addEdge(i, j, edges[i][j]);
				}
			}
		}
	}

	@Override
	public boolean addEdge(int u, int v, T weight) {
		if (hasEdge(u, v)) {
			return false;
		}
		addAdjacent(u, new WeightedAdjacentVertex<T>(v, weight));
		addAdjacent(v, new WeightedAdjacentVertex<T>(u, weight));
		return true;
	}

	@Override
	public T getWeight(int u, int v) {
		var vertexV = getAdjacentVertex(u, v);
		if (vertexV!=null) {
			return vertexV.getWeight();
		}
		return null;
	}

	@Override
	public IWeightedAdjacentVertex<T> getAdjacentVertex(int u, int v) {
		var vertex = super.getAdjacentVertex(u, v);
		return vertex!=null 
				? (IWeightedAdjacentVertex<T>) super.getAdjacentVertex(u, v)
				: null;
	}

}
