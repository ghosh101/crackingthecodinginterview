package com.cracking.interview.strings;

public class Problem_1_5_OneAway {

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "pales";
		
		boolean check = isOneEditAway(s1, s2);
		System.out.println(check);
	}

	private static boolean isOneEditAway(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1) return false;
		
		if(s1.length() == s2.length()) {
			int count = 0;
			
			for(int i=0; i<s1.length(); i++) {
				if(count > 1) return false;
				if(s1.charAt(i) != s2.charAt(i)) count++;
			}
		}else {
			String str1 = s1;
			String str2 = s2;
			
			if(s1.length() < s2.length()) {
				str1 = s2;
				str2 = s1;
			}
			
			int count = 0;
			for(int i=0, j=0; i<str2.length(); j++) {
				if(str1.charAt(j) != str2.charAt(i)) {
					count++;
				}else {
					i++;
				}
				
				if(count > 1) return false;
			}
		}
		
		return true;
	}

}