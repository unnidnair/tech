package com.concept.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintBFS {

	public static void main(String[] args) {
		PrintBFS bfs = new PrintBFS();
		Node root = bfs.buildTree();
		printTree(root);
	}
	
	private static void printTree(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int levelNodes = 0;
		//boolean reverse=false;
		while (q.size() > 0) {
			levelNodes = q.size();
			while(levelNodes > 0) {
				Node n = q.poll();
				System.out.print (n.value);
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

	private Node buildTree() {
		
//        1
//     /     \
//    2       3
//  /   \       \
// 4     5       6
//      /  \     /
//     7    8   9
		
		Node node = new Node();
		node.value=1;
		
		Node node2 = new Node();
		node2.value=2;
		Node node3 = new Node();
		node3.value=3;
		
		node.left=node2;
		node.right=node3;
		
		Node node4 = new Node();
		node4.value=4;
		Node node5 = new Node();
		node5.value=5;
		
		node2.left=node4;
		node2.right=node5;
		
		Node node7 = new Node();
		node7.value=7;
		Node node8 = new Node();
		node8.value=8;
		
		node5.left=node7;
		node5.right=node8;
		
		Node node6 = new Node();
		node6.value=6;
		
		node3.right=node6;
		
		Node node9 = new Node();
		node9.value=9;
		
		node6.left=node9;
		
		return node;
	}

	class Node {
		int value;
		Node left;
		Node right;
	}

}
