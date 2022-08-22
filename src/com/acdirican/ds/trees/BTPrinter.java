package com.acdirican.ds.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BTPrinter<T extends Comparable<T>> {
	private BinaryTree<T> bt;

	public BTPrinter(BinaryTree<T> bt) {
		super();
		this.bt = bt;
	}
	
	public void printMidOrderReverse() {
		printMidOrderReverse(bt.getRoot());
		System.out.println();
	}
	private void printMidOrderReverse(BTNode<T> current) {
		if (current == null) {
			return;
		}
		printMidOrderReverse(current.right);
		System.out.print(current.data + " ");
		printMidOrderReverse(current.left);
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
	
	public void printBFS() {
		Queue<BTNode<T>> q =  new LinkedList<>();
		q.add(bt.root);
		while(!q.isEmpty()) {
			BTNode<T> curr = q.poll();
			System.out.print(curr.getData() +" ");
			if (curr.left!=null) {
				q.add(curr.left);
			}
			if (curr.right!=null) {
				q.add(curr.right);
			}
		}
		System.out.println();
	}
	
	public void printLevelOrderQueue() {
		Queue<BTNode<T>> q =  new LinkedList<>();
		q.add(bt.root);

		while(!q.isEmpty()) {
			int count = q.size();
			
			for(int i=0; i< count; i++) {
				BTNode<T> curr = q.poll();
				System.out.print(curr.getData() +" ");
				if (curr.left!=null) {
					q.add(curr.left);
				}
				if (curr.right!=null) {
					q.add(curr.right);
				}
			}
			
		}
		System.out.println();
	}
	
}
