package com.concept.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//http://www.geeksforgeeks.org/merge-k-sorted-arrays/
public class MergeNSortedArrays {
	
	/*
	Merge K sorted arrays in sorted order.
	a: [ 1, 5, 10 ]
	b: [ 2, 4, 6 ]
	c: [ 3, 7, 11 ]
	d: [ 8, 9 ]
	m = merge( [a, b, c, d] )
	m : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
	*/
    public static void main (String... args) {
    	MergeNSortedArrays m = new MergeNSortedArrays	();
        int[][] arrays = {{1, 5, 10},{2, 4, 6},{3, 7, 11},{8, 9,10}};
        int[] merged = m.merge(arrays, 3, arrays.length);
        for (int i:merged) {
            System.out.print(i + " ");
        }
    }
    
	public int[] merge(int[][] arrays, int n, int k) {
		int output[] = new int[n*k];
		PriorityQueue<MinNode> queue = new PriorityQueue<>();
		
		//MinNode[] nodes = new MinNode[k];
		List<MinNode> nodes = new ArrayList<>();
		for (int i=0; i<k; i++) {
			MinNode node = new MinNode();
			node.element=arrays[i][0]; //Store first element
			node.i=i; //index of array
			node.j=1; //Index of next element from array
			//nodes[i] = node;
			nodes.add(node);
		}
		
		//queue.addAll(Arrays.asList(nodes));
		queue.addAll(nodes);
		
		for (int count=0; count<n*k; count++) {
			MinNode node = queue.poll();
			output[count] = node.element;
			node.j += 1;
			
			if (node.j < n) {
				node.element = arrays[node.i][node.j];
			} else {
				node.element = Integer.MAX_VALUE;
			}
			
			queue.add(node);
		}
		
		return output;
	}
	
	class MinNode implements Comparable {
		int element;
		int i;
		int j;
		
		@Override
		public int compareTo(Object o) {
			int response = -1;
			MinNode that = (MinNode) o;
			if (that.element==this.element) response = 0;
			else if (that.element < this.element) response = 1;
			return response;
		}
	}
	
	

}