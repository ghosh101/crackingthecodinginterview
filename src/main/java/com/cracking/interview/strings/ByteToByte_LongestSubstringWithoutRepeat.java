package com.cracking.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class ByteToByte_LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		
		String s = "bbbbb";
		
		int result = findLongestSubstringWithoutRepeatCharacters(s);
		System.out.println(result);
	}

	//Sliding Window problem
	private static int findLongestSubstringWithoutRepeatCharacters(String s) {
		if(s.equals("") || s == null) return 0;
		
		Set<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int result = 0;
		
		for(; j<s.length(); ) {
			char c = s.charAt(j);
			
			if(set.contains(c)) {
				char ch = s.charAt(i);
				set.remove(ch);
				i++;
			}else {
				result = Math.max(result, j-i);
				set.add(c);
				j++;
			}
		}
		return result + 1;
	}

}
