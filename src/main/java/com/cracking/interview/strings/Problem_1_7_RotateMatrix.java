package com.cracking.interview.strings;

public class Problem_1_7_RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6}, {7,8,9}};

		rotateMatrix(matrix);
	}

	private static int[][] rotateMatrix(int[][] matrix) {

		int[][] result = new int[matrix.length][matrix.length];

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				result[j][matrix.length-1 - i] = matrix[i][j];
			}
		}

		return result;
	}

}