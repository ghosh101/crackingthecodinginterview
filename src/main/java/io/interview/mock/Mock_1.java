package io.interview.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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

		String s = "acbbsab";
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('b');
		set.add('c');
		set.add('s');

		//String subString = findMinLengthSubstring(s, set);
		String subStringOptimal = findMinLengthSubstringOptimal(s, set);
		System.out.println(subStringOptimal);

	}

	//O(N) solution -- Based on sliding window principle
	private static String findMinLengthSubstringOptimal(String s, Set<Character> set) {
		int min_length = Integer.MAX_VALUE;
		String result = "";

		List<Character> tempList = new ArrayList<>();
		for(int i=0, j=0; ; ) {
			if(tempList.containsAll(set)) {
				if(tempList.size() <= min_length) min_length = tempList.size();
				result = tempList.toString();

				tempList.remove(0);
				i++;
				
				continue;
			}
			
			if(j >= s.length()) break;
			
			if(set.contains(s.charAt(j))){
				tempList.add(s.charAt(j));
				j++;
			}else {
				tempList = new ArrayList<>();
				j++;
			}

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