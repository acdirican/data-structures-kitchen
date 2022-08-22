package com.acdirican.ds.heap.binary;

import java.util.Arrays;
import java.util.StringJoiner;

public class MinHeap<T extends Comparable<T>> extends BinaryHeap<T>{

	public MinHeap(int capacity) {
		super(capacity);
	}

	@Override
	public void add(T data) {
		if (size == capacity) {
			throw new RuntimeException("Insufficient capacity to add a new element");
		}
		this.heap[size++] =  new HeapNode<>(data);
		int i = size-1;
		int p = parent(i);
		while(i >=0 && heap[i].compareTo(heap[p]) < 0) {
			swap(i, p);
			i=p;
			p = parent(i);
		}
	}
	
	
	public T getMin() {
		if (size == 0) {
			throw new RuntimeException("No data in the heap");
		}
		T min = heap[0].data;
		size--;
		heap[0] = heap[size];
		heapify();
		return min;
	}
	@Override
	public String toString() {
		return Arrays.toString(heap);
	}

	@Override
	public void heapify() {
		if (size ==0) {
			return;
		}
		
		int i = 0;
		int l = left(i);
		int r = right(i);
		
		while(i<size && (l<size && heap[l].compareTo(heap[i])<0) || (r<size && heap[r].compareTo(heap[i])<0)){
			
			if( heap[l].compareTo(heap[i])<0 && heap[r].compareTo(heap[i])<0) {
				if (heap[l].compareTo(heap[r])<0){
					swap(i,l);
					i=l;
				}
				else {
					swap(i, r);
					i=r;
				}
			}
			else if (heap[l].compareTo(heap[i])<0 ) {
				swap(i,l);
				i=l;
			} else {
				swap(i, r);
				i=r;
			}
			
			l = left(i);
			r = right(i);
		}
		
	}

	@Override
	public String toStringSorted() {
		int previousSize = size;
		HeapNode<T>[] copy = new HeapNode[capacity];
		for(int i=0; i<size; i++) {
			copy[i] = heap[i];
		}
		StringJoiner joiner =  new StringJoiner(", ");
		while(size>0) {
			T min = getMin();
			joiner.add(min.toString());
		}
		heap = copy;
		size = previousSize;
		return joiner.toString();
	}
	
}
