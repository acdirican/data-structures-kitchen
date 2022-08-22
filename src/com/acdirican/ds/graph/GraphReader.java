package com.acdirican.ds.graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

import com.acdirican.ds.graph.abstracts.Graph;

public class GraphReader {
	public static List<String> readFile(String fileName){
		List<String> lines;
		try {
			lines = Files.readAllLines(Path.of(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return lines;
	}
	public static <T>  WeightedDiGraph<T> readWeighteDiGraph(String fileName, Function<String, T> parser) {
		
		List<String> lines = readFile(fileName);
		int nVertices = Integer.parseInt(lines.get(0));
		WeightedDiGraph<T> graph =  new WeightedDiGraph<>(nVertices);
		
		lines.stream().skip(1).forEach(l-> {
			String[] edge = l.split("\s");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			T w = parser.apply(edge[2]);
			graph.addEdge(u, v, w);
		});
		
		return graph;
	}
	
	public static UnWeightedDiGraph readUnWeightedDiGraph(String fileName) {
		List<String> lines = readFile(fileName);
		int nVertices = Integer.parseInt(lines.get(0));
		UnWeightedDiGraph graph =  new UnWeightedDiGraph(nVertices);
		
		lines.stream().skip(1).forEach(l-> {
			String[] edge = l.split("\s");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			graph.addEdge(u, v);
		});
		
		return graph;
	}
	
	public static <T> WeightedGraph<T> readWeightedGraph(String fileName,  Function<String, T> parser) {
		List<String> lines = readFile(fileName);
		int nVertices = Integer.parseInt(lines.get(0));
		WeightedGraph<T> graph = new WeightedGraph<>(nVertices);
		lines.stream().skip(1).forEach(l-> {
			String[] edge = l.split("\s");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			T w = parser.apply(edge[2]);
			graph.addEdge(u, v, w);
		});
		
		return graph;
	}
	public static UnWeightedGraph readGraph(String fileName) {
		List<String> lines = readFile(fileName);
		int nVertices = Integer.parseInt(lines.get(0));
		UnWeightedGraph  graph = new UnWeightedGraph(nVertices);
		lines.stream().skip(1).forEach(l-> {
			String[] edge = l.split("\s");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			graph.addEdge(u, v);
		});
		
		return graph;
	}
}
