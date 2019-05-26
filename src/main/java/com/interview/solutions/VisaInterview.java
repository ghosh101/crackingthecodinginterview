package com.interview.solutions;

import java.util.ArrayList;
import java.util.List;

public class VisaInterview {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(10);
		list.add(2);
		list.add(4);
		list.add(8);
		list.add(1);
		
		System.out.println(maxDifference(list));
	}

	private static int maxDifference(List<Integer> list) {
		int maxDifference = -1;
		
		for(int i=list.size()-1, j=i-1; j>=0; ) {
			if(list.get(j) > list.get(i)) {
				i = j;
				j--;
			}
			
			if(list.get(j) < list.get(i)) {
				int diff = list.get(i) - list.get(j);
				if(diff > maxDifference) {
					maxDifference = diff;
				}
				j--;
			}
		}
		return maxDifference;
	}

}