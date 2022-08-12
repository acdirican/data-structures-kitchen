package com.acdirican.ds.trees;

public class BTPrinter<T extends Comparable<T>> {
	private BinaryTree<T> bt;

	public BTPrinter(BinaryTree<T> bt) {
		super();
		this.bt = bt;
	}
	
	public void printMidOrder() {
		printMidOrder(bt.getRoot());
		System.out.println();
	}

	private void printMidOrder(BTNode<T> current) {
		if (current == null) {
			return;
		}
		printMidOrder(current.left);
		System.out.print(current.data + " ");
		printMidOrder(current.right);
	}
	
	public void printPreOrder() {
		printPreOrder(bt.getRoot(), 0);
		System.out.println();
	}

	private void printPreOrder(BTNode<T> current, int length) {
		if (current == null) {
			return;
		}
		writeData(current.data, length);
		printPreOrder(current.left, length + 1);
		printPreOrder(current.right, length + 1);
	}
	
	private void writeData(T data, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("  ");
		}
		System.out.println("->" + data);
		
	}

	public void printLevelOrder() {
		int treeHeight = bt.getHeight();
		for(int l = 0; l<treeHeight; l++) {
			System.out.printf("(Level %5d): ", l);
			printLevelOrder(bt.getRoot(), l);
			System.out.println();
			
		}
	}
	private void printLevelOrder(BTNode<T> current, int d) {
		if ( current == null) {
			return;
		}
		
		if (d==0) {
			System.out.print(current.data + " ");
		}
		else {
			printLevelOrder(current.left, d-1);
			printLevelOrder(current.right, d-1);
		}
		
	}
	
}
