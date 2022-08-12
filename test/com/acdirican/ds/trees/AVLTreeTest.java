package com.acdirican.ds.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


class AVLTreeTest extends BTTest {

	@BeforeEach
	void setUp() throws Exception {
		bt =  new AVLTree<Integer>();
		insertTestData();		
	}


}
