package com.acdirican.ds.trees;

/**
 * AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of left and 
 * right subtrees cannot be more than one for all nodes. 
 * 
 * @author Ahmet Cengizhan Dirican
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BST<T> {
		
	@Override
	protected BTNode<T> insert(BTNode<T> current, BTNode<T> inserting) {
		current = super.insert(current, inserting);
		return balance(current);
	}
	
	private BTNode<T> balance(BTNode<T> current) {
		int balance = getBalance(current);
		if (Math.abs(balance) <= 1) {
			return current;
		}

		//Balancing
		if (balance>0) { //The imbalance comes from left
			if (getBalance(current.left)>0) { //from the left grand child
				//right rotation on current
				current = rightRotation(current);
			}
			else { // from the right grand child
				//left rotation on the left child + right rotation on current
				current.left = leftRotation(current.left);
				current = rightRotation(current);
			}
		}
		else { //The imbalance comes from the right child
			if (getBalance(current.right) < 0) { // from the right grand child
				//right rotation on the current
				current = leftRotation(current);
			}
			else {
				current.right = rightRotation(current.right);
				current = leftRotation(current);
			}
		}
		return current;
	}

	private BTNode<T> leftRotation(BTNode<T> node) {
		BTNode<T> rightChild = node.right;
		node.right = rightChild.left;
		rightChild.left = node;
		return rightChild;
	}

	private BTNode<T> rightRotation(BTNode<T> node) {
		BTNode<T> leftChild = node.left;
		node.left = leftChild.right;
		leftChild.right = node;
		return leftChild;
	}

	@Override
	protected BTNode<T> remove(BTNode<T> current, T data) {
		current = super.remove(current, data);
		return balance(current);
	}

	
	public int getBalance(BTNode<T> node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
	
}
