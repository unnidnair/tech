package com.concept.interview;

import java.util.ArrayDeque;
import java.util.Queue;

public class EmployeeLevels {

	public static void main(String[] args) {
		EmployeeLevels levels = new EmployeeLevels();
		int level = levels.computeLevels(75, 7);
		System.out.println("Total levels in the company is " + level);
	}

	private int computeLevels(int empCount, int batch) {
		
		Node parent = new Node();
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(parent);
		parent.nodes = new Node[7];
		
		int levelNodes = 0; int tmpLevelNodes = 0;
		int depth = 0;
		
		while(empCount > 0 && !queue.isEmpty()) {
			
			int count = 0;
			levelNodes = queue.size();
			tmpLevelNodes = levelNodes;
			
			while (empCount > 0 && levelNodes > 0) {
				Node base = queue.poll();
				count = 0;
				while(empCount > 0 && count < 7) {
					Node child = new Node();
					child.nodes = new Node[7];
					base.nodes[count] = child;
					count++; empCount--;
					queue.add(child);
				}
				if (empCount==0) {
					break;
				} else {
					levelNodes--;
				}
			}
			
			System.out.println("Remaining " + empCount + " employees after level " + (depth+2));
			
			
			System.out.println("Level " + ++depth + " has " + tmpLevelNodes + " employees");
			
			if (empCount == 0 && count > 0) {
				System.out.println("Level " + ++depth + " has " + count + " employees");
			}
		}
		
		return depth;
		
		
	}
	
	class Node {
		Node[] nodes;
		int value;
	}

}
