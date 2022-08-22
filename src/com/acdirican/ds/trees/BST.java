package com.acdirican.ds.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.IntStream;

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
		} else if (inserting.data.compareTo(current.data) > 0) {
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
		if (data.equals(current.data)) {
			if (current.left != null) {
				current.right = insert(current.right, current.left);
			}
			current = current.right;

			this.size--;
		} else if (data.compareTo(current.data) < 0) {
			current.left = remove(current.left, data);
		} else if (data.compareTo(current.data) > 0) {
			current.right = remove(current.right, data);
		}
		return current;
	}

	@Override
	public boolean contains(T data) {
		return find(root, data) != null;
	}

	private BTNode<T> find(BTNode<T> current, T data) {
		if (current == null) {
			return null;
		}

		if (data.compareTo(current.data) == 0) {
			return current;
		} else if (data.compareTo(current.data) < 0) {
			return find(current.left, data);
		}

		return find(current.right, data);
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
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

	public T findKthLargest(int k) {
		if (root != null)
			return findKthLargest(root, k, new int[1]);
		throw new NoSuchElementException();
	}

	private T findKthLargest(BTNode<T> current, int k, int[] c) {
		if (current == null || c[0] >= k) {
			return null;
		}

		T result = findKthLargest(current.right, k, c);
		if (result != null) {
			return result;
		}
		c[0]++;
		if (c[0] == k) {
			return current.data;
		}

		return findKthLargest(current.left, k, c);
	}

	@Override
	public Range<T> findRange(T data) {
		if (root == null) {
			return null;
		}
		return findRange(root, data);
	}

	private Range<T> findRange(BTNode<T> current, T data) {
		if (current == null) {
			return null;
		}

		Range<T> result = null;

		if (data.compareTo(current.data) == 0) {
			result = new Range<T>(data, data);
		} else if (data.compareTo(current.data) < 0) {
			result = findRange(current.left, data);
			if (result == null) {// it's a leaf, then current is an upper bound
				T val = (current.left != null ? current.left.data : null);
				result = new Range<T>(val, current.data);
			} else {
				if (result.getMax() == null) { // it comes from the right side
					if (data.compareTo(current.data) < 0) {
						result.setMax(current.data);
					}
				}
			}
		} else {
			result = findRange(current.right, data);
			if (result == null) { // it is a leaf, then current is lower bound
				T val = (current.right != null ? current.right.data : null);
				result = new Range<T>(current.data, val);
			} else {
				if (result.getMin() == null) { // it comes from the left side
					if (data.compareTo(current.data) > 0) {
						result.setMin(current.data);
					}
				}
			}
		}
		return result;
	}

	public int getWidth() {
		int h = getHeight();
		return IntStream.range(1, h + 1).map(level -> getWidth(root, level)).max().orElse(0);
	}

	private int getWidth(BTNode<T> node, int level) {
		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		}

		if (level > 1) {
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		}

		return 0;
	}


	public int getWidthUsingQueue() {
		Queue<BTNode<T>> q =  new LinkedList<>();
		q.add(root);
		int width = 0;
		while(!q.isEmpty()) {
			int count = q.size();
			width =  Math.max(width, count);
			
			for(int i=0; i< count; i++) {
				BTNode<T> curr = q.poll();
				if (curr.left!=null) {
					q.add(curr.left);
				}
				if (curr.right!=null) {
					q.add(curr.right);
				}
			}
			
		}
		return width;
	}
	
	public int getGidthWithNullLeaves() {
		Map<Integer, Integer> leftMost =  new HashMap<>();
		Map<Integer, Integer> rightMost =  new HashMap<>();
		
		getWidthWithNullLeavesHelper(root, 0, 0, leftMost, rightMost);
		
		System.out.println(leftMost);
		System.out.println(rightMost);
		return rightMost.entrySet()
				.stream()
				.mapToInt(e->e.getValue() - leftMost.get(e.getKey()))
				.max()
				.orElse(0) + 1;
	}

	private void getWidthWithNullLeavesHelper(BTNode<T> node, int level, int i, Map<Integer, Integer> leftMost,
			Map<Integer, Integer> rightMost) {
		if (node == null) {
			return;
		}
		
		int min = leftMost.getOrDefault(level, i);
		leftMost.put(level, Math.min(i, min));
		
		int max = rightMost.getOrDefault(level, i);
		rightMost.put(level, Math.max(i, max));
		
		getWidthWithNullLeavesHelper(node.left, level + 1, 2*i+1, leftMost, rightMost);
		getWidthWithNullLeavesHelper(node.right, level + 1, 2*i+2, leftMost, rightMost);
	}
}
