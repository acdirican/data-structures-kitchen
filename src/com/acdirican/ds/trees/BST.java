package com.acdirican.ds.trees;

import java.util.StringJoiner;

public class BST<T extends Comparable<T>> extends BinaryTree<T> {
	
	@Override
	public void insert(T data) {
		this.root = insert(root, new BTNode<>(data));
		this.size++;
	}

	protected BTNode<T> insert(BTNode<T> current, BTNode<T> inserting) {
		if (current == null) {
			return inserting;
		}
		
		if (inserting.data.compareTo(current.data) < 0) {
			current.left = insert(current.left, inserting);
		}
		else if (inserting.data.compareTo(current.data) > 0 ) {
			current.right = insert(current.right, inserting);
		}
		return current;
	}
	
	@Override
	public void remove(T data) {
		this.root = remove(root, data);
	}

	protected BTNode<T> remove(BTNode<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (data.equals(current.data)) 
		{
			if (current.left != null) {
				current.right = insert(current.right, current.left);
			}
			current = current.right;
			
			this.size--;
		}
		else if (data.compareTo(current.data) < 0) {
			current.left = remove(current.left, data);
		}
		else if (data.compareTo(current.data) >0 ) {
			current.right = remove(current.right, data);
		}
		return current;
	}

	@Override
	public boolean contains(T data) {
		return find(root, data) != null;
	}

	private BTNode<T> find(BTNode<T> current, T data) {
		if (current ==  null) {
			return null;
		}
		
		if (data.compareTo(current.data) == 0) {
			return current;
		}
		else if (data.compareTo(current.data) < 0 ) {
			return find(current.left, data);
		}
		
		return find(current.right, data);		
	}

	public String toString() {
		StringJoiner joiner =  new StringJoiner(", ");
		toString(root, joiner);
		return joiner.toString();
	}

	private void toString(BTNode<T> current, StringJoiner joiner) {
		if (current == null) {
			return;
		}
		toString(current.left, joiner);
		joiner.add(current.data.toString());
		toString(current.right, joiner);
	}

	@Override
	public int getHeight() {
		return getHeight(root);
	}

	protected int getHeight(BTNode<T> current) {
		if (current == null) {
			return 0;
		}
		int l = getHeight(current.left);
		int r = getHeight(current.right);
		
		return 1 + Math.max(l, r);
	}
	
}
