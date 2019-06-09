package com.cracking.interview.strings;

public class ByteToByte_ValidPalindrome {

	public static void main(String[] args) {
		String s = "0P";
		
		boolean check = validPalindrome(s);
		System.out.println(check);
	}

	private static boolean validPalindrome(String s) {
		s = s.toLowerCase();
		char[] arr = s.toCharArray();
		
		int i = 0;
		int j = arr.length - 1;
		
		for(; j >= i; ) {
			char ch1 = arr[i];
			char ch2 = arr[j];
			
			if(!Character.isLetterOrDigit(ch1)) {
				i++;
				continue;
			}
			if(!Character.isLetterOrDigit(ch2)) {
				j--;
				continue;
			}
			
			if(ch1 != ch2) return false;
			i++;
			j--;
		}
		return true;
	}

}
