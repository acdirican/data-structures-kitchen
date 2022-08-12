package com.acdirican.ds.trees;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Runner {
	

	static void insertTestData(int[] testData, BinaryTree<Integer> bt) {
		Arrays.stream(testData).forEach(bt::insert);
	}
	
	public static void main(String[] args) {
		int[] testData = {32, 25, 10, 60, 22, 30,  20, 42, 43,79,80, 7, 90, 8};
		BinaryTree<Integer> bt;
		BTPrinter printer;
		
		bt = new BST<>();
		insertTestData(testData, bt);
		printer = new BTPrinter<>(bt);
		System.out.println(bt);
		printer.printPreOrder();

		System.out.println("--------------------");
		
		bt =  new AVLTree<>();
		
		insertTestData(testData, bt);
		printer =  new BTPrinter<>(bt);
		System.out.println(bt);
		printer.printPreOrder();
	}
}
