package com.acdirican.ds.graph;

import java.util.Objects;

import com.acdirican.ds.graph.abstracts.IAdjacentVertex;

public class AdjacentVertex implements IAdjacentVertex {
	private int adjacent;
	
	public AdjacentVertex(int adjacent) {
		this.adjacent = adjacent;
	}
	
	@Override
	public int getAdjacent() {
		return adjacent;
	}

	@Override
	public String toString() {
		return "[" + getAdjacent() +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjacent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (obj instanceof AdjacentVertex other) {
			return adjacent == other.adjacent;
		}
		return false;
	}
	


}
