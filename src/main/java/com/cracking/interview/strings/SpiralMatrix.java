package com.cracking.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};

		List<Integer> list = spiralMatrix(matrix);
		list.forEach(i -> System.out.print(i));
	}

	//Time: O(MN), Space: O(1)
	//Concept is to decrease the max row size and max column size after we traverse it.
	//Also decrease the starting row and starting column after traversal
	private static List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> list = new ArrayList<>();

		int m = matrix.length; //max row
		int n = matrix[0].length; //max column
		int k = 0; //start row
		int l = 0; //start column
		
		int i = 0;
		while(k < m && l < n) {
			for(i = l; i < n; i++) {
				list.add(matrix[k][i]);
			}
			k++;
			
			for(i = k; i < m; i++) {
				list.add(matrix[i][n-1]);
			}
			n--;
			
			if(k < m) {
				for(i = n; i > l; i--) {
					list.add(matrix[m-1][i-1]);
				}
				m--;
			}
			
			
			if(l < n) {
				for(i = m; i > k; i--) {
					list.add(matrix[i-1][l]);
				}
				l++;
			}
			
		}
		
		return list;
	}

}
