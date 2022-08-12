package com.acdirican.ds.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class BTTest {

	protected int[] testData = {32, 25, 10, 60, 22, 30,  20, 42, 43,79,80, 7, 90, 8};
	protected BinaryTree<Integer> bt;

	protected void insertTestData() {
		Arrays.stream(testData).forEach(bt::insert);
	}
	
	@Test
	void testInsert() {
		assertEquals(testData.length, bt.size());
	}

	@Test
	void testRemove() {
		assertEquals(testData.length, bt.size());
		bt.remove(8);
		assertFalse(bt.contains(8));
		assertEquals(testData.length-1, bt.size());
		
		bt.remove(7);
		assertFalse(bt.contains(7));
		assertEquals(testData.length-2, bt.size());
		
		bt.remove(32);
		assertFalse(bt.contains(32));
		assertEquals(testData.length-3, bt.size());
	}

	@Test
	void testContains() {
		assertEquals(false, bt.contains(99));
		assertEquals(true, bt.contains(7));
	}
	
	@Test
	void testToString() {
		Arrays.sort(testData);
		String expected = Arrays.stream(testData).boxed().map(String::valueOf).collect(Collectors.joining(", "));
		assertEquals(expected, bt.toString());
	}

}
