package com.concept.algorithms.tree;

import java.util.List;

import com.concept.pojo.Node;

import java.util.ArrayList;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * https://www.programcreek.com/2014/05/leetcode-binary-tree-paths-java/
 */
public class BinaryTreeAllPaths {

	public static void main(String[] args) {
		BinaryTreeAllPaths path = new BinaryTreeAllPaths();
		Node root = Node.buildTree();
		List<String> binaryPaths = path.binaryTreePaths(root);
		for (String s : binaryPaths) {
			System.out.println(s);
		}
	}
	
	public List<String> binaryTreePaths(Node root) {
	    ArrayList<String> finalResult = new ArrayList<String>();
	 
	    if(root==null)
	        return finalResult;
	 
	    ArrayList<String> curr = new ArrayList<String>();
	    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	 
	    dfs(root, results, curr);
	 
	    for(ArrayList<String> al : results){
	        StringBuilder sb = new StringBuilder();
	        sb.append(al.get(0));
	        for(int i=1; i<al.size();i++){
	            sb.append("->"+al.get(i));
	        }
	 
	        finalResult.add(sb.toString());
	    }
	 
	    return finalResult;
	}
	 
	public void dfs(Node root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
	    curr.add(String.valueOf(root.value));
	 
	    if(root.left==null && root.right==null){
	        list.add(curr);
	        return;
	    }
	 
	    if(root.left!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.left, list, temp);
	    }
	 
	    if(root.right!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.right, list, temp);
	    } 
	}

}
