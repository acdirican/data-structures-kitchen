package com.acdirican.ds.graph.abstracts;

import java.util.Map;

public interface IDiGraph extends IBaseGraph{
	int inDegree(int u);
	int outDegree(int u);
	Map<Integer, Integer> inDegreeAll();
	Map<Integer, Integer> outDegreeAll();

}
