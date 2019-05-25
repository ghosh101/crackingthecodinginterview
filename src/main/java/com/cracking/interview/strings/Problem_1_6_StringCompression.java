package com.cracking.interview.strings;

public class Problem_1_6_StringCompression {

	public static void main(String[] args) {
		String s = "aabcccccaaa";
		
		String result = compressedString(s);
		System.out.println(result);
	}

	private static String compressedString(String s) {
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		int i = 0;
		for(; i<s.length()-1; i++) {
			if(sb.toString().length() >= s.length()) return s; //to validate if compressed string becomes larger than the original string
			
			if(s.charAt(i) != s.charAt(i+1)) {
				sb.append(s.charAt(i));
				sb.append(count);
				count = 1;
			}else {
				count++;
			}
		}
		sb.append(s.charAt(i)).append(count);
		return sb.toString();
	}

}
