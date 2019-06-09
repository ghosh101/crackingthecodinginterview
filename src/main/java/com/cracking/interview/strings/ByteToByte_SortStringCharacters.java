package com.cracking.interview.strings;

public class ByteToByte_SortStringCharacters {

	public static void main(String[] args) {
		String s = "bbccdaefbbaa";

		String result = sortString(s);
		System.out.println(result);
	}

	private static String sortString(String s) {
		int[] arr = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			arr[c - 97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				char c = (char) (i + 97);
				
				for(int j = 0; j<arr[i]; j++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
		
	}

}
