package com.cracking.interview.strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Problem_1_4_PalindromPermutation {

	public static void main(String[] args) {
		String s = "tact coapapa";

		boolean check = ifPalindromePermutation(s);
		System.out.println(check);
	}

	private static boolean ifPalindromePermutation(String s) {

		char[] ch = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for(int i=0; i<ch.length; i++) {
			if(ch[i] != ' ') {
				if(map.containsKey(ch[i])) {
					int val = map.get(ch[i]);
					map.put(ch[i], val+1);
				}else {
					map.put(ch[i], 1);
				}
			}
		}

		Collection<Integer> valueList = map.values();
		int count = 0;
		
		for(Integer value: valueList) {
			if(count > 1) return false;
			if(value%2 != 0) count++;
		}

		return true;
	}

}
