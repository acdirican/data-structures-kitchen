package com.acdirican.ds.trees;

import org.junit.jupiter.api.BeforeEach;

class BSTTest extends BTTest{
	
	@BeforeEach
	void setUp() throws Exception {
		bt =  new BST<Integer>();
		insertTestData();		
	}

	

}
