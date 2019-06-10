package com.cracking.interview.dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {1,3,6,7,9,4,10,5,6};

		int len = findLongestIncreasingSubsequence(arr);
		System.out.println(len);
	}

	//Time: O(N^2) as for each element we are checking from the 0th element
	//Space: O(N) as we are using an cache array to store the dynamic programming results
	private static int findLongestIncreasingSubsequence(int[] arr) {
		int[] cache = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			cache[i] = 1;
		}
		
		int i = 0;
		int j = 0;
		while(j < arr.length) {
			if(i == j) {
				i = 0;
				j++;
			}else if(arr[j] > arr[i]) {
				cache[j] = Math.max(cache[i] + 1, cache[j]);
				i++;
			}else {
				i++;
			}
		}
		
		int maxLen = 0;
		for(int x = 0; x < arr.length; x++) {
			maxLen = Math.max(maxLen, cache[x]);
		}
		
		return maxLen;
	}

}
