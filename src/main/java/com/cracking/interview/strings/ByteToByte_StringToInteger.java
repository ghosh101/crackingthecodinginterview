package com.cracking.interview.strings;

public class ByteToByte_StringToInteger {

	public static void main(String[] args) {
		String s = "42";
		
		int i = stringToInt(s);
		System.out.println(i);
	}

	private static int stringToInt(String s) {
		int num = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			num = num + (s.charAt(i) - '0') * (int) Math.pow(10, Math.abs(i - s.length() + 1));
		}
		return num;
	}

}
