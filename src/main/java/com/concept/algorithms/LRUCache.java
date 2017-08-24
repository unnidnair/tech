package com.concept.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache< K, V > extends LinkedHashMap < K, V > {

	public static void main(String[] args) {
		LRUCache<String, String> cache = new LRUCache<>(10);
	}
	
	private int capacity; // Maximum number of items in the cache.
    
    public LRUCache(int capacity) { 
        super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return (size() > this.capacity);
    } 

}
