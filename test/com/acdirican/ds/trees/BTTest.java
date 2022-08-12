package com.acdirican.ds.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
	
	@Test
	void testFindRange() {
		new BTPrinter<>(bt).printPreOrder();
		//7, 8, 10, 20, 22, 25, 30, 32, 42, 43, 60, 79, 80, 90
		assertEquals(new Range<Integer>(8,8), bt.findRange(8));
		assertEquals(new Range<Integer>(8,10), bt.findRange(9));
		assertEquals(new Range<Integer>(10,20), bt.findRange(15));
		
		assertEquals(new Range<Integer>(32,42), bt.findRange(35));
		assertEquals(new Range<Integer>(60,79), bt.findRange(65));
		assertEquals(new Range<Integer>(80,90), bt.findRange(85));
		
		assertEquals(new Range<Integer>(null,7), bt.findRange(6));
		assertEquals(new Range<Integer>(90,null), bt.findRange(100));
	}

}
