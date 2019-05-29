package io.pramp.mock;

import java.util.Stack;

/* Implement a regular expression function isMatch that supports the '.' and '*' symbols. 
 * The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression. 
 * For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.
 * In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal, 
 * where the '.' is treated as a single a character wildcard (see third example), 
 * and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples). 
 *
 * For more information on regular expression matching, see the Regular Expression Wikipedia page.
 * 
 * Explain your algorithm, and analyze its time and space complexities.
 * 
 * input:  text = "aa", pattern = "a"
 * output: false
 *
 * input:  text = "aa", pattern = "aa"
 * output: true
 *
 * input:  text = "abc", pattern = "a.c"
 * output: true
 *
 * input:  text = "abbb", pattern = "ab*"
 * output: true
 *
 * input:  text = "acd", pattern = "ab*c."
 * output: true
 */

public class Mock_1_Interviewer {

	static boolean isMatch(String text, String pattern) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<pattern.length(); i++){
			stack.push(pattern.charAt(i));
		}

		int i = text.length()-1;
		
		while(!stack.isEmpty()){
			char c = stack.pop();
			
			if(c == '.'){
				i--;
				continue;
			}else if(c == '*'){
				char ch = stack.pop();
				
				if(ch == '.') {
					if(!stack.isEmpty()) {
						char t = text.charAt(i);
						i--;
						
						while(i > 0 && t == text.charAt(i)){
							i--;
						}
					}else {
						return true;
					}
				}
				
				while(i >= 0 && text.charAt(i) == ch){
					i--;
				}
			}else{
				if(c != text.charAt(i)) return false;
				i--;
			}
		}
		
		if(i >= 0) return false;
		
		return true;
	}

	public static void main(String[] args) {

		String text = "abaaab";
		String pattern = "ab.*";

		boolean check = isMatch(text, pattern);
		System.out.println(check);
	}

}
