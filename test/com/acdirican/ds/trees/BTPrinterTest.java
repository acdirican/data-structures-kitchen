package com.acdirican.ds.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BTPrinterTest extends BTTest {
	
	protected int[] testData = {32, 25, 10, 60, 22, 30,  20, 42, 43,79,80, 7, 90, 8};
	protected BinaryTree<Integer> bt;

	protected void insertTestData() {
		Arrays.stream(testData).forEach(bt::insert);
	}
	private BTPrinter<Integer> printer;
	
	@BeforeEach
	public void setUp() {
		bt =  new BST<>();
		insertTestData();
		printer =  new BTPrinter<>(bt);
	}
	
	@Test
	void testPrintMidOrder() {
		printer.printMidOrder();
	}
	
	@Test
	void testPrintLevelOrder() {
		printer.printLevelOrder();
	}
	
	@Test
	void testPrintPreOrder() {
		printer.printPreOrder();
	}

}
