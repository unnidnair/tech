package com.concept.algorithms.tree;

import com.concept.pojo.Node;

/**
 * Lowest common ancestor in binary search tree.
 *
 * Time complexity O(height of tree)
 * Space complexity O(height of tree)
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Video - https://www.youtube.com/watch?v=TIoCCStdiFo
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LowestCommonAncestoryBinarySearchTree.java
 */
public class LCABinarySearchTree {
	public Node lowestCommonAncestor(Node root, int p, int q) {
        if (root.data > Math.max(p, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.data < Math.min(p, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
