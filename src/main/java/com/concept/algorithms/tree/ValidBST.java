package com.concept.algorithms.tree;

import com.concept.pojo.Node;

public class ValidBST {

	public static void main(String[] args) {
		ValidBST valueid = new ValidBST();
		Node root = Node.buildTree1();
		Node.printTree(root);
		System.out.println(valueid.isValidBST(root));
	}
	
	public boolean isValidBST(Node root) {
	    if(root==null)
	        return true;
	 
	    return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	 
	public boolean helper(Node root, double low, double high){
	 
	    if(root.value<=low || root.value>=high)
	        return false;
	 
	    if(root.left!=null && !helper(root.left, low, root.value)){
	        return false;
	    }
	 
	    if(root.right!=null && !helper(root.right, root.value, high)){
	        return false;
	    }
	 
	    return true;    
	}

}
