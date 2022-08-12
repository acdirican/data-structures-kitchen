package com.acdirican.ds.trees;

import java.util.Objects;

public class Range<T> {
	private T min;
	private T max;
	public Range(T min, T max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public T getMin() {
		return min;
	}
	public void setMin(T min) {
		this.min = min;
	}
	public T getMax() {
		return max;
	}
	public void setMax(T max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return "Range [min=" + min + ", max=" + max + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(max, min);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		return Objects.equals(max, other.max) && Objects.equals(min, other.min);
	}
	
}
