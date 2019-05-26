package com.cracking.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class Problem_1_8_ZeroMatrix {

	static class Point{
		int row;
		int col;

		Point(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,0,1,0},{3,4,0,1,4,6}, {1,2,3,4,5,1}};

		//zeroMatrixWithPointClass(matrix);
		zeroMatrixWithBooleanArrays(matrix);
	}
	
	private static void zeroMatrixWithBooleanArrays(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {

				if(matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for(int rowNum=0; rowNum < rows.length; rowNum++) {
			if(rows[rowNum]) {
				for(int j=0; j < matrix[rowNum].length; j++) {
					matrix[rowNum][j] = 0;
				}
			}
		}

		for(int colNum=0; colNum < cols.length; colNum++) {
			if(cols[colNum]) {
				for(int i=0; i < matrix.length; i++) {
					matrix[i][colNum] = 0;
				}
			}
		}
		return;
	}

	private static void zeroMatrixWithPointClass(int[][] matrix) {
		List<Point> pointList = new ArrayList<>();
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {

				if(matrix[i][j] == 0) {
					pointList.add(new Point(i, j));
				}
			}
		}

		for(Point p: pointList) {
			int rowNum = p.row;

			for(int j=0; j<matrix[rowNum].length; j++) {
				matrix[rowNum][j] = 0;
			}
		}

		for(Point p: pointList) {
			int colNum = p.col;

			for(int i=0; i<matrix.length; i++) {
				matrix[i][colNum] = 0;
			}
		}
	}

}