package com.acdirican.ds.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest extends BTTest{
	
	@BeforeEach
	void setUp() throws Exception {
		bt =  new BST<Integer>();
		insertTestData();		
	}

	

}
