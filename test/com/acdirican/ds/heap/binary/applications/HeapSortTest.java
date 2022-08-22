package com.acdirican.ds.heap.binary.applications;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void testSort() {
		Integer[] data = {10,9,8,7,6,5,4,3,2,1};
		Integer[] sorted = {1,2,3,4,5,6,7,8,9,10};
		HeapSort.sort(data);
		assertArrayEquals(data, sorted);
	}

}
