package com.acdirican.ds.heap.binary;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

	private int[] data = {1,2,3,4,5,6,7,8,9,10}; //	private int[] data = {10,9,8,7,6,5,4,3,2,1};
	private MaxHeap<Integer> heap = null;
	@BeforeEach
	public void setUp() {
		heap =  new MaxHeap<>(data.length);
		Arrays.stream(data).forEach(v->heap.add(v));
	}
	@Test
	void testAdd() {
		System.out.println(heap);
		assertEquals(data.length, heap.size());
		assertEquals(10, heap.get(0));
		assertEquals(3, heap.get(9));
		assertThrows(RuntimeException.class, () -> heap.add(0));
	}

	@Test
	void testGetMax() {
		for(int i=data.length-1; i>=0; i--) {
			assertEquals(data[i], heap.getMax());
		}
	}
	
	@Test
	void testGet() {
		assertEquals(3, heap.get(9));
		assertThrows(IllegalArgumentException.class, ()->heap.get(-1));
		assertThrows(IllegalArgumentException.class, ()->heap.get(11));
	}


	@Test
	void testToStringSorted() {
		assertEquals("10, 9, 8, 7, 6, 5, 4, 3, 2, 1", heap.toStringSorted());
		assertEquals("10, 9, 8, 7, 6, 5, 4, 3, 2, 1", heap.toStringSorted());
		
	}

}
