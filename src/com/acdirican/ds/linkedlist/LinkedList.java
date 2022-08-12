package com.acdirican.ds.linkedlist;

public interface LinkedList<T> {
	
	int size();
	boolean isEmpty();
	T get(int i);
	int indexOf(T data);
	
	boolean set(T currentValue, T newValue);
	void insert(T data);
	boolean remove(T data);
	void print();
	
	default boolean contains(T data) {
		return indexOf(data) != -1;
	}
	
}
