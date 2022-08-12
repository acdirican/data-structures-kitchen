package com.acdirican.ds.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<T> implements LinkedList<T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	
	@Override
	public T get(int index) {
		if (index<0 || index>=size()) {
			return null;
		}
		
		Node<T> node = getNode(index);
		return node != null ? node.getData() : null;
	}
	
	private Node<T> getNode(int index){
		int i = 0;
		Node<T> current = head;
		while(i<index && current != null) {
			i++;
			current = current.getNext();
		}
		
		return current; 
	}
	
	private Node<T> getNode(T data){
		Node<T> current = head;
		while(current != null && !current.getData().equals(data)) {
			current = current.getNext();
		}
		
		return current; 
	}
	
	@Override
	public int indexOf(T data) {
		int i = 0;
		Node<T> current = head;
		while(current != null && !current.getData().equals(data)) {
			i++;
			current = current.getNext();
		}
		return i != size() ? i : -1; 
	}
	

	@Override
	public boolean set(T currentValue, T newValue) {
		Node<T> node = getNode(currentValue);
		if (node != null) {
			node.setData(newValue);
			return true;
		}
		return false;
	}
	@Override
	public void insert(T data) {
		Node<T> node =  new Node<>(data);
		if (isEmpty()) {
			head =  node;
			tail = head;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
		size++;
		
	}
	@Override
	public boolean remove(T data) {
		Node<T> previous = null;
		Node<T> current = head;
		while(current != null && !current.getData().equals(data)) {
			previous =  current;
			current = current.getNext();
		}
		
		if (current != null) {
			//head
			if (previous == null) {
				head = current.getNext();
			}
			else {
				previous.setNext(current.getNext());
				if (current == tail) {
					tail = previous;
				}
			}
			size--;
			return true;
		}
		return false;		
	}
	
	@Override
	public void print() {
		System.out.print("Singly LinkedList = {");
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.getData());
			current = current.getNext();
			if (current != null) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	@Override
	public String toString() {
		StringJoiner joiner =  new StringJoiner(", ", "Singly LinkedList = {", "}");
		Node<T> current = head;
		while(current != null) {
			joiner.add(current.getData().toString());
			current = current.getNext();
		}
		return joiner.toString();
	}
	
	
}
