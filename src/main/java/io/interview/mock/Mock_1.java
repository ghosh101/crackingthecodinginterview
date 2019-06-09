package io.interview.mock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Write a function that takes an input string and an alphabet and returns the minimum continuous substring which contains every letter of the alphabet at least once.

Example 1:

Input: “acbbsab”
Alphabet: {'a', 'b', ‘c’, ’s'}
Output: "acbbs" or “cbbsa”

Example 2: 

Input: “aaaabbbbbcacccc”
Alphabet: {‘a’, ‘b’, ‘c’}
Output: "bca"

45 min question. Try to find the O(N) solution.

 */
public class Mock_1 {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC";
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 1);
		map.put('B', 1);
		//map.put('s', 1);

		//String subString = findMinLengthSubstring(s, set);
		String subStringOptimal = findMinLengthSubstringOptimal(s, map);
		System.out.println(subStringOptimal);
	}

	//O(N) solution -- Based on sliding window principle
	//Time Complexity: O(|S| + |T|) where |S| and |T| represent the lengths of strings S and T. In the worst case we might end up visiting every element of string S twice, once by left pointer and once by right pointer. |T| represents the length of string T.
	//Space Complexity: O(|S| + |T|). |S| when the window size is equal to the entire string S. |T| when T has all unique characters. 
	private static String findMinLengthSubstringOptimal(String s, Map<Character, Integer> map) {
		int min_length = Integer.MAX_VALUE;
		String result = "";

		Map<Character, Integer> charMap = new HashMap<>();
		int charactersToMatch = map.size();
		int freqMatched = 0;
		
		int start = 0;
		int end = 0;
		while(end < s.length()) {
			char c = s.charAt(end);
			int value = charMap.getOrDefault(c, 0);
			charMap.put(c, value + 1);
			
			boolean isValidCharacter = map.containsKey(c);
			if(isValidCharacter && charMap.get(c) == map.get(c)) {
				freqMatched++;
			}
			
			while(freqMatched == charactersToMatch) {
				char ch = s.charAt(start);
				charMap.put(ch, charMap.get(ch) - 1);
				
				isValidCharacter = map.containsKey(ch);
				if(isValidCharacter && charMap.get(ch) < map.get(ch)) {
					freqMatched--;
				}
				
				String str = s.substring(start, end + 1);
				if(str.length() < min_length) {
					min_length = str.length();
					result = str;
				}
				start++;
			}
			end++;
		}
		
		return result;
	}


	//O(N^2) solution
	private static String findMinLengthSubstring(String s, Set<Character> set) {
		int min_length = Integer.MAX_VALUE;
		String result = "";

		for(int i=0; i<s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			Set<Character> tempSet = new HashSet<>();

			for(int j=i; j<s.length(); j++) {
				if(set.contains(s.charAt(j))) {
					sb.append(s.charAt(j));
					tempSet.add(s.charAt(j));

					if(tempSet.containsAll(set)) {
						if(sb.toString().length() <= min_length) {
							min_length = sb.toString().length();
							result = sb.toString();
						}
						break;
					}
				}else {
					break;
				}
			}
		}

		return result;
	}

}