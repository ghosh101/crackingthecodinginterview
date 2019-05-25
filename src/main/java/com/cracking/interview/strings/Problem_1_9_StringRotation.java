package com.cracking.interview.strings;

public class Problem_1_9_StringRotation {

	public static void main(String[] args) {
		String s1 = "erbottlewat";
		String s2 = "waterbottle";
		
		boolean check = isSubstring(s1, s2);
		System.out.println(check);
	}

	private static boolean isSubstring(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		s1 = s1 + s1;
		
		if(s1.contains(s2)) return true;
		return false;
	}

}
