package com.acdirican.ds.trees;

public abstract class BinaryTree<T extends Comparable<T>> {
	protected BTNode<T> root;
	protected long size = 0;
	
	public BTNode<T> getRoot() {
		return root;
	}
	
	
	public long size() {
		return size;
	}
	
	public abstract void insert(T data);
	public abstract void remove(T data);
	public abstract boolean contains(T data);
	public abstract int getHeight();
	
}
