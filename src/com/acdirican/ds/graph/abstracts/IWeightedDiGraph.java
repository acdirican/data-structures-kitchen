package com.acdirican.ds.graph.abstracts;

public interface IWeightedDiGraph<T> extends IDiGraph {
	boolean addEdge(int u, int v, T weight);
	T getWeight(int u, int v);
}
