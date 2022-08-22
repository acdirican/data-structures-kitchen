package com.acdirican.ds.heap.binary;

public class Runner {
	public static void main(String[] args) {
		MinHeap<Integer> minHeap =  new MinHeap<>(5);
		minHeap.add(5);
		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(2);
		minHeap.add(1);
		
		System.out.println(minHeap);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(minHeap.getMin());
		}

	}
}
