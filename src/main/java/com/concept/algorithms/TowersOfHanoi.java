package com.concept.algorithms;

public class TowersOfHanoi {

	public static void main(String[] args) {
		TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
		towersOfHanoi.solveTowersOfHanoi(3, 'A', 'B', 'C');
	}

	private void solveTowersOfHanoi(int numDisks, char from, char intermediate, char to) {
		if (1==numDisks) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			solveTowersOfHanoi (numDisks-1, from, to, intermediate);
			System.out.println("Disk " + numDisks + " from " + from + " to " + to);
			solveTowersOfHanoi (numDisks-1, intermediate, from, to);
		}
		
	}

}
