package com.acdirican.ds.graph.applications;

import java.util.Objects;

class Degree implements Comparable<Degree>{
	int vertex;
	int degree;
	Degree(int vertex, int degree){
		this.degree = degree;
		this.vertex = vertex;
	}
	@Override
	public int compareTo(Degree o) {
		return this.degree - o.degree;
	}
	@Override
	public int hashCode() {
		return Objects.hash(vertex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Degree other = (Degree) obj;
		return vertex == other.vertex;
	}
	@Override
	public String toString() {
		return "Degree [vertex=" + vertex + ", degree=" + degree + "]";
	}
	
	
}