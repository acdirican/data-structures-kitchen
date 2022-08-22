package com.acdirican.ds.heap.binary;

/*
 * A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.

	The root element will be at Arr[0].
	Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
		Arr[(i-1)/2]	Returns the parent node
		Arr[(2*i)+1]	Returns the left child node
		Arr[(2*i)+2]	Returns the right child node 
 *
 */
public abstract class BinaryHeap<T extends Comparable<T>> {
	protected int capacity;
	protected int size=0;
	protected HeapNode<T>[] heap;
	
	public BinaryHeap(int capacity) {
		this.capacity = capacity;
		this.heap =  new HeapNode[capacity];
	}
		
	protected int parent(int i) {
		return (i-1)/2;
	}
	
	protected int left(int i) {
		return 2*i + 1;
	}
	
	protected int right(int i) {
		return 2*i+2;
	}
	
	protected void swap(int i, int j) {
		HeapNode<T> temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int i) {
		if (i<0 || i>size) {
			throw new IllegalArgumentException();
		}
		return heap[i].data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public abstract String toStringSorted();
	public abstract void add(T data);
	public abstract void heapify();
	
	
}
