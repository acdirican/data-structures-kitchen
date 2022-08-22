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
	public abstract int getWidth();
	public abstract int getWidthUsingQueue();
	public abstract int getGidthWithNullLeaves();
	public abstract T findKthLargest(int k);
	/**
	 * Return the range where the given data is in. 
	 * 
	 * If the data is already in the tree the method returns a range whose min and max are the same,
	 *, otherwisit returns the narrower range possible. 
	 * 
	 * If the given data smaller or bigger than all the data in the tree, the method returns 
	 * either of the range {min=null, max=first_value} or {min=last value, max=null}
	 * 
	 * @param data the given data
	 * @return the narrower range of the given data
	 */
	public abstract Range<T> findRange(T data);
	
}
