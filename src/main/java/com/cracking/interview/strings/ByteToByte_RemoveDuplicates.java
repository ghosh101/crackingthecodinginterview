package com.cracking.interview.strings;

public class ByteToByte_RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		
		int count = removeDuplicates(arr);
		System.out.println(count);
	}

	private static int removeDuplicates(int[] arr) {
		int i = 0;
		int j = 0;
		for(; j<arr.length-1; ) {
			if(arr[j+1] == arr[i]) {
				j++;
			}else {
				i++;
				arr[i] = arr[j+1];
			}
		}
		return i+1;
	}

}
