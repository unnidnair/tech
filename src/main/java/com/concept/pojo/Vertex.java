package com.concept.pojo;

import java.util.Set;

public class Vertex<T> {
	
	Set<Vertex<T>> adjacentVertexes;

	public Set<Vertex<T>> getAdjacentVertexes() {
		return adjacentVertexes;
	}

}
