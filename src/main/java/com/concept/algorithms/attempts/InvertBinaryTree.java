package com.concept.algorithms.attempts;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.concept.algorithms.PrintBFS;
import com.concept.pojo.Node;

public class InvertBinaryTree {

	public static void main(String[] args) {
		
		InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
		
		Node root = Node.buildTree();
		System.out.println("Original Tree");
		PrintBFS.printTree(root);
		
		System.out.println("");
		invertBinaryTree.invertRecursive(root);
		System.out.println("Inverted Tree By Recursion");
		PrintBFS.printTree(root);
		
		System.out.println("");
		root = Node.buildTree();
		invertBinaryTree.invertIterative(root);
		System.out.println("Inverted Tree By Iterative");
		PrintBFS.printTree(root);
	}

	//Recursive way
	private Node invertRecursive(Node root) {
		
		if(null!=root) {
			invertNode(root);
		}
		return root;
	}

	private void invertNode(Node root) {
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if (null!=root.left) {
			invertNode(root.left);
		}
		
		if(null!=root.right) {
			invertNode(root.right);
		}
		
	}
	
	//Iterative way
	private Node invertIterative(Node root) {
		
		Queue<Node> queue = new ArrayDeque<>();
		if(root!=null){
	        queue.add(root);
	    }
		
		while(!queue.isEmpty()){
			Node p = queue.poll();
	        if(p.left!=null)
	            queue.add(p.left);
	        if(p.right!=null)
	            queue.add(p.right);
	 
	        Node temp = p.left;
	        p.left = p.right;
	        p.right = temp;
	    }
		
		return root;
	}
}


