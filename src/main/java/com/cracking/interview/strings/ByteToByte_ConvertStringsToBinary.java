package com.cracking.interview.strings;

public class ByteToByte_ConvertStringsToBinary {

	public static void main(String[] args) {
		String s = "GFG";
		
		String[] arr = convertToBinary(s);
		for(String str: arr) {
			System.out.println(str);
		}
	}

	private static String[] convertToBinary(String s) {
		String[] arr = new String[s.length()];
		
		for(int i = 0; i<s.length(); i++) {
			int j = s.charAt(i);
			
			StringBuilder sb = new StringBuilder();
			while(j > 0) {
				int rem = j % 2;
				j = j / 2;
				sb.append(rem);
			}
			sb.reverse();
			arr[i] = sb.toString();
		}
		return arr;
	}

}
