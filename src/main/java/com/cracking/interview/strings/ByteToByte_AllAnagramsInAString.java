package com.cracking.interview.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByteToByte_AllAnagramsInAString {

	public static void main(String[] args) {
		String s = "baa";
		String p = "aa";

		List<Integer> list = findAllAnagrams(s, p);
		list.forEach(i -> System.out.println(i));
	}

	//Time: O(S + T) as we have two pointers working together to reach the end, Space: O(S + T) where M and N are the size of the 2 strings
	private static List<Integer> findAllAnagrams(String s, String t) {
		List<Integer> result = new ArrayList<>();
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<t.length(); i++) {
			int val = map.getOrDefault(t.charAt(i), 0);
			map.put(t.charAt(i), val + 1);
		}
		
		Map<Character, Integer> charMap = new HashMap<>();
		int frequenciesToMatch = map.size();
		int freqMatched = 0;
		
		int start = 0;
		int end = 0;
		while(end < s.length()) {
			char c = s.charAt(end);
			int value = charMap.getOrDefault(c, 0);
			charMap.put(c, value + 1);
			
			boolean isValidChar = map.containsKey(c);
			if(isValidChar && map.get(c) == charMap.get(c)) {
				freqMatched++;
			}
			
			while(freqMatched == frequenciesToMatch) {
				char ch = s.charAt(start);
				charMap.put(ch, charMap.get(ch) - 1);
				
				isValidChar = map.containsKey(ch);
				if(isValidChar && charMap.get(ch) < map.get(ch)) {
					freqMatched--;
				}
				
				if(t.length() == end-start+1) {
					result.add(start);
				}
				start++;
			}
			end++;
		}
		
		return result;	
	}

}
