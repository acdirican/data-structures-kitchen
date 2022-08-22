package com.acdirican.ds.heap.binary.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.acdirican.ds.heap.binary.MinHeap;

public class HeapSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		MinHeap<T> heap =  new MinHeap<>(arr.length);
		Arrays.stream(arr).forEach(heap::add);
		List<T> sorted =  new ArrayList<>(arr.length);
		while(!heap.isEmpty()) {
			sorted.add(heap.getMin());
		}
		sorted.toArray(arr);
	}
}
