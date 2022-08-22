package com.acdirican.ds.trees;

import java.util.Arrays;

public class Runner {
	

	static void insertTestData(int[] testData, BinaryTree<Integer> bt) {
		Arrays.stream(testData).forEach(bt::insert);
	}
	
	public static void main(String[] args) {
		//int[] testData = {32, 25, 10, 60, 22, 30,  20, 42, 43,79,80, 7, 90, 8};
		int[] testData = {20,10,30,5,15,40,35,50};
		BinaryTree<Integer> bt;
		BTPrinter<Integer> printer;
		
		bt = new BST<>();
		insertTestData(testData, bt);
		printer = new BTPrinter<>(bt);
		System.out.println(bt);
		System.out.println("--------------------");
		printer.printMidOrderReverse();
		System.out.println("--------------------");
		for (int i = 1; i <= testData.length; i++) {
			System.out.print(bt.findKthLargest(i) + " - ");
		}
		System.out.println();
		System.out.println("--------------------");
		System.out.println("width:" + bt.getWidth());
		System.out.println("width:" + bt.getWidthUsingQueue());
		System.out.println("width:" + bt.getGidthWithNullLeaves());
		System.out.println("height:" + bt.getHeight());
		System.out.println("--------------------");
		printer.printLevelOrder();
		System.out.println("--------------------");
		printer.printBFS();
		System.out.println("--------------------");
		printer.printLevelOrderQueue();
		System.out.println("--------------------");
		BinaryTree<Integer>  avlT =  new AVLTree<>();

		insertTestData(testData, avlT);
		printer =  new BTPrinter<>(avlT);
		System.out.println(avlT);
		printer.printPreOrder();
	}
}
