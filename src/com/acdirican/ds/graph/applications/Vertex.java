package com.acdirican.ds.graph.applications;

import java.util.Arrays;
import java.util.Objects;

class Vertex implements Comparable<Vertex> {
	int vertex = 0;
	double[] distance;

	public Vertex(int v, double[] distance) {
		this.vertex = v;
		this.distance = distance;
	}

	double getDistance() {
		return distance[vertex];
	}

	@Override
	public int compareTo(Vertex o) {
		if (this.getDistance() < o.getDistance()) {
			return -1;
		}
		else if (this.getDistance() > o.getDistance()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "[v:" + vertex + ", d:" + getDistance() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(distance);
		result = prime * result + Objects.hash(vertex);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return  vertex == other.vertex;
	}
	
	
}