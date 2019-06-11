package com.cracking.interview.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {10, 100, 80, 30, 90, 40, 50, 70, 1};

		quickSort(arr, 0, arr.length - 1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
  
	private static void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int pivot = partition(arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[r];

		int i = l-1; //saves the position after which the pivot element will be placed
		int j = l; //used to iterate

		while(j < r) {
			if(arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			j++;
		}

		int temp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = temp;

		return i+1;
	}

}
