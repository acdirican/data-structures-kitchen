package com.acdirican.ds.heap.binary;

public class HeapNode<T extends Comparable<T>> implements Comparable<HeapNode<T>>{
	protected T data;

	public HeapNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}


	@Override
	public int compareTo(HeapNode<T> o) {
		if (o == null) {
			return 1;
		}
		return this.data.compareTo(o.data);
	}
	
	
	
}
