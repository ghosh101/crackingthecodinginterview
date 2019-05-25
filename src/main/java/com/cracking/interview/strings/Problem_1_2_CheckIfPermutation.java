package com.cracking.interview.strings;

import java.util.Arrays;

public class Problem_1_2_CheckIfPermutation {

	public static void main(String[] args) {
		String s1 = "array    ";
		String s2 = "ss    aya";
		
		boolean check = ifPermutation(s1, s2);
		System.out.println(check);
	}

	private static boolean ifPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		for(int i=0; i<ch1.length; i++) {
			if(ch1[i] != ch2[i]) return false;
		}
		return true;
	}

}
