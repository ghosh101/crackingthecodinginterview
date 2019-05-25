package com.cracking.interview.strings;

public class Problem_1_3_Urlify {

	public static void main(String[] args) {
		String s = "Mr John Smith    ";
		int len = 13;
		
		String result = urlify(s, len);
		System.out.println(result);
	}

	private static String urlify(String s, int len) {
		char[] ch = s.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; i++) {
			if(ch[i] != ' ') sb.append(ch[i]);
			else {
				sb.append("%20");
			}
		}
		
		return sb.toString();
	}

}
