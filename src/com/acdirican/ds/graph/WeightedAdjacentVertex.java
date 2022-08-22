package com.acdirican.ds.graph;

import java.util.Objects;

import com.acdirican.ds.graph.abstracts.IWeightedAdjacentVertex;

public class WeightedAdjacentVertex<T> implements IWeightedAdjacentVertex<T> {
	private int adjacent;
	private T weight;
	
	
	public WeightedAdjacentVertex(int adjacent, T weight) {
		super();
		this.adjacent = adjacent;
		this.weight = weight;
	}
	
	@Override
	public int getAdjacent() {
		return adjacent;
	}
	@Override
	public T getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeight(T weight) {
		this.weight = weight;
	}
	
	
	@Override
	public String toString() {
		return "V[a=" + adjacent + ", w=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjacent, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (obj instanceof WeightedAdjacentVertex other) {
			return adjacent == other.adjacent && Objects.equals(weight, other.weight);
		}
		return false;
	}


	


}
