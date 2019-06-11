package com.cracking.interview.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {10, 100, 80, 30, 90, 40, 50, 70, 1};
		
		mergeSort(arr, 0, arr.length - 1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if(l < r) {
			int mid = (l + r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			
			merge(arr, l, r, mid);
		}
	}

	private static void merge(int[] arr, int l, int r, int mid) {
		int[] larray = new int[mid - l + 1];
		int[] rarray = new int[r - mid]; //don't include the mid
		
		for(int i = 0; i<larray.length; i++) {
			larray[i] = arr[l + i];
		}
		
		for(int j = 0; j<rarray.length; j++) {
			rarray[j] = arr[mid + j + 1];
		}
		
		//merge the two arrays
		int i = 0;
		int j = 0;
		
		int k = l; //k will take the starting position in the main array
		while(i < larray.length && j < rarray.length) {
			if(larray[i] <= rarray[j]) {
				arr[k] = larray[i];
				i++;
			}else {
				arr[k] = rarray[j];
				j++;
			}
			k++;
		}
		
		//copy any remaining elements from the larray or the rarray
		while(i < larray.length) {
			arr[k] = larray[i];
			i++;
			k++;
		}
		
		while(j < rarray.length) {
			arr[k] = rarray[j];
			j++;
			k++;
		}
		
		return;
	}

}
