package com.concept.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import com.concept.pojo.Node;

public class PrintBFS {

	public static void main(String[] args) {
		PrintBFS bfs = new PrintBFS();
		Node root = Node.buildTree1();
		printTree(root);
	}
	
	public static void printTree(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int levelNodes = 0;
		//boolean reverse=false;
		while (q.size() > 0) {
			levelNodes = q.size();
			while(levelNodes > 0) {
				Node n = q.poll();
				System.out.print (n.value + " ");
//				if (reverse) {
//					if (n.right!=null) q.add(n.right);
//					if (n.left!=null) q.add(n.left);
//				} else {
					if (n.left!=null) q.add(n.left);
					if (n.right!=null) q.add(n.right);
//				}
				
				levelNodes--;
			}
			//reverse=!reverse;
			System.out.println("");
		}
		
	}
}
