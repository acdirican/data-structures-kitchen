package com.acdirican.ds.graph.abstracts;

public interface IWeightedAdjacentVertex<T> extends IAdjacentVertex{
	
	/**
	 * 
	 * @return the weight of the edge
	 */
	T getWeight();

	/**
	 * Sets the wieght of the vertex
	 * 
	 * @param value
	 */
	void setWeight(T value);
	
}
