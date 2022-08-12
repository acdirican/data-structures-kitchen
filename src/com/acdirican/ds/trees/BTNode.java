package com.acdirican.ds.trees;
/**
 * Binary Tree node
 * 
 * @author Ahmet Cengizhan Dirican
 *
 * @param <T>
 */
public class BTNode<T extends Comparable<T>> {
	protected T data;
	protected BTNode<T> left;
	protected BTNode<T> right;
	public BTNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}
	public BTNode<T> getRight() {
		return right;
	}
	public void setRight(BTNode<T> right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "BTNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
