package com.concept.algorithms.attempts;

import com.concept.pojo.Node;

/**
 * Diameter of a Binary Tree
 * 
 * The diameter of a tree (sometimes called the width) is the number of nodes on the 
 * longest path between two leaves in the tree. The diagram below shows two trees each 
 * with diameter nine, the leaves that form the ends of a longest path are shaded 
 * (note that there is more than one path in each tree of length nine, but no path 
 * longer than nine nodes).
 * 
 * The diameter of a tree T is the largest of the following quantities:
 * the diameter of T’s left subtree
 * the diameter of T’s right subtree
 * the longest path between leaves that goes through the root of 
 * 			T (this can be computed from the heights of the subtrees of T)
 */	
public class LongestPathBetweenTwoLeafNodes {

	public static void main(String[] args) {
		LongestPathBetweenTwoLeafNodes path = new LongestPathBetweenTwoLeafNodes();
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		System.out.println(path.findLongestPath(node));		
	}

	private int findLongestPath(Node node) {
		
		if (null==node) return 0;
		
		int leftHeight = findHeight(node.left);
		int rightHeight = findHeight(node.right);
		
		int leftLongest = findLongestPath(node.left);
		int rightLongest = findLongestPath(node.right);
		
		return Math.max(leftHeight+rightHeight+1, Math.max(leftLongest, rightLongest));
	}

	private int findHeight(Node node) {
		if (null==node) return 0;
		return (1 + Math.max(findHeight(node.left), findHeight(node.right)));
	}

}