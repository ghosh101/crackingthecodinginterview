package io.pramp.mock;

import java.util.Stack;

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
