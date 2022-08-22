package com.acdirican.ds.graph.abstracts;

public interface IWeightedGraph<T> extends IGraph {
	boolean addEdge(int u, int v, T weight);
	T getWeight(int u, int v);
}
