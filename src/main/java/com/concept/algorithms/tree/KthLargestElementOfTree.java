package com.concept.algorithms.tree;

import java.util.Stack;

import com.concept.pojo.Node;

public class KthLargestElementOfTree {

	public static void main(String[] args) {
		KthLargestElementOfTree kth = new KthLargestElementOfTree();
		Node root = Node.buildTree();
		Node.printTree(root);
		System.out.println(kth.kthSmallest(root, 2));
	}
	
	public int kthSmallest(Node root, int k) {
	    Stack<Node> stack = new Stack<Node>();
	 
	    Node p = root;
	    int result = 0;
	 
	    while(!stack.isEmpty() || p!=null){
	        if(p!=null){
	            stack.push(p);
	            p = p.left;
	        }else{
	            Node t = stack.pop();
	            k--;
	            if(k==0)
	                result = t.value;
	            p = t.right;
	        }
	    }
	 
	    return result;
	}

}
