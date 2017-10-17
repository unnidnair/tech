package com.concept.pojo;

import java.util.Set;

public class Graph<T> {
	
	boolean directed = false;
	Set<Vertex<T>> vertices;
	
	public Graph() {
		
	}
	
	public Graph(boolean directed) {
		this.directed = directed;
	}

	public Set<Vertex<T>> getAllVertex() {
		return vertices;
	}

	public void addEdge(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
