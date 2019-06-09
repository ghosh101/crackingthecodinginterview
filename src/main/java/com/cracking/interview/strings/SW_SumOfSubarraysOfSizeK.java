package com.cracking.interview.strings;

public class SW_SumOfSubarraysOfSizeK {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,6,3};
		int k = 3;

		sumOfSubArraysOfSizeK(arr, k);
	}

	private static void sumOfSubArraysOfSizeK(int[] arr, int k) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			
			if(i == k - 1) {
				System.out.println(sum);
			}else if(i >= k) {
				sum = sum - arr[i-k];
				System.out.println(sum);
			}
		}
	}

}
