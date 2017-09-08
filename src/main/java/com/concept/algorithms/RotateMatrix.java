package com.concept.algorithms;

public class RotateMatrix {

	public static void main(String[] args) {
		RotateMatrix matrix = new RotateMatrix();
		int[][] matrixObject = { 
				{ 1,  2,  3,  4 }, 
				{ 5,  6,  7,  8 },
				{ 9,  10, 11, 12 }, 
				{ 13, 14, 15, 16 } 
		};
		matrix.rotate(matrixObject, matrixObject.length);
		matrix.print(matrixObject, matrixObject.length);
	}

	private void print(int[][] matrixObject, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(matrixObject[i][j] + " ");
			System.out.println("");
		}
	}

	public void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				
				int offset = i - first;
				int top = matrix[first][i]; // save top 
				
				System.out.println("first " + first + " last " + last + "offset " + offset + " layer " + layer + " i " + i + " n " + n);

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}

}
