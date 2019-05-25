package com.cracking.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class Problem_1_1_IsUnique {

	public static void main(String[] args) {
		String s = "uncopyrightable dermatoglyphics";
		
		boolean check = checkHasUniqueCharacters(s);
		System.out.println(check);
	}

	private static boolean checkHasUniqueCharacters(String s) {
		char[] ch = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<ch.length; i++) {
			if(map.containsKey(ch[i])) {
				return false;
			}
			else {
				map.put(ch[i], 0);
			}
		}
		return true;
	}

}
