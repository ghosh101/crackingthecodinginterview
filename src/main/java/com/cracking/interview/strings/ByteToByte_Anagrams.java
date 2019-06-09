package com.cracking.interview.strings;

public class ByteToByte_Anagrams {

	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "AA";
		
		boolean check = isAnagram(s1, s2);
		System.out.println(check);
	}

	private static boolean isAnagram(String s1, String s2) {
		int[] arr = new int[256];
		
		for(int i=0; i<s1.length(); i++) {
			char c = s1.charAt(i);
			if(c >= 65 && c <= 90) {
				c += 32;
			}
			arr[c - 0]++;
		}
		
		for(int i=0; i<s2.length(); i++) {
			char c = s2.charAt(i);
			if(c >= 65 && c <= 90) {
				c += 32;
			}
			arr[c - 0]--;
			
			if(arr[c-0] < 0) return false;
		}
		
		return true;
	}

}
