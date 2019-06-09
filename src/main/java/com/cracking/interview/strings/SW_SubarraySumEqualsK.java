package com.cracking.interview.strings;

public class SW_SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		int k = 2;
		
		int count = countSubarraySumEqualsK(arr, k);
		System.out.println(count);
	}

	private static int countSubarraySumEqualsK(int[] arr, int k) {
		int count = 0;
		
		int i = 0;
		int j = 0;
		int sum = arr[j];
		
		for(; j < arr.length - 1;) {
			
			if(sum > k) {
				sum = sum - arr[i];
				i++;
				continue;
			}
			
			j++;
			sum = sum + arr[j];
			
			if(sum == k) {
				count++;
			}
			
			
		}
		
		return count;
		
	}

}
