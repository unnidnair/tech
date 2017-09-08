package com.concept.algorithms;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializeDeserialize {

	public static void main(String[] args) {
		BinaryTreeSerializeDeserialize btsd = new BinaryTreeSerializeDeserialize();
		
		TreeNode root = btsd.buildTree();
		btsd.printTree(root);
		
		String serialized = btsd.serialize(root);
		System.out.println(serialized);
		
		TreeNode deserialized = btsd.deserialize(serialized);
		btsd.printTree(deserialized);
	}
	
	private String serialize(TreeNode root) {
		
		if(root==null){
	        return "";
	    }
		
		StringBuilder sb = new StringBuilder();
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			 TreeNode t = queue.poll();
			 if(t!=null) {
				 sb.append(String.valueOf(t.getValue()) + ",");
				 queue.add(t.left);
		         queue.add(t.right);
			 } else {
				 sb.append("#,");
			 }   
		}
		sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb.toString());
	    return sb.toString();
	}
	
	private TreeNode deserialize(String data) {
		
		if(data==null || data.length()==0)
	        return null;
		
		String[] arr = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	    
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int i=1;
		
		while(!queue.isEmpty()){
			
			TreeNode t = queue.poll();
			if(t==null) continue;
			
			if(!arr[i].equals("#")){
	            t.left = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.left);
			} else {
	            t.left = null;
	            queue.offer(null);
	        }
	        i++;
	        
	        if(!arr[i].equals("#")){
	            t.right = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.right);
	 
	        }else{
	            t.right = null;
	            queue.offer(null);
	        }
	        i++;
		}
		
		return root;
	}

	

	private void printTree(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int levelNodes = 0;
		//boolean reverse=false;
		while (q.size() > 0) {
			levelNodes = q.size();
			while(levelNodes > 0) {
				TreeNode n = q.poll();
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

	private TreeNode buildTree() {
		
		TreeNode tn = new TreeNode();
		tn.setValue(1);
		
		TreeNode tn2 = new TreeNode();
		tn2.setValue(2);
		
		TreeNode tn3 = new TreeNode();
		tn3.setValue(3);
		
		tn.setLeft(tn2);
		tn.setRight(tn3);
		
		TreeNode tn4 = new TreeNode();
		tn4.setValue(4);
		
		TreeNode tn5 = new TreeNode();
		tn5.setValue(5);
		
		tn2.setLeft(tn4);
		tn2.setRight(tn5);
		
		return tn;
	}

	public class TreeNode {
		
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {}
		
		public TreeNode(int value) {
			this.value = value;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * @return the left
		 */
		public TreeNode getLeft() {
			return left;
		}
		/**
		 * @param left the left to set
		 */
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		/**
		 * @return the right
		 */
		public TreeNode getRight() {
			return right;
		}
		/**
		 * @param right the right to set
		 */
		public void setRight(TreeNode right) {
			this.right = right;
		}
	}
}
