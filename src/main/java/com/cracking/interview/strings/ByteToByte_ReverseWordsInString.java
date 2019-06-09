package com.cracking.interview.strings;

public class ByteToByte_ReverseWordsInString {

	public static void main(String[] args) {
		String s = "cake pound steal";
		
		System.out.println(reverseString(s));
	}

	private static String reverseString(String s) {
		char[] arr = s.toCharArray();
		
		for(int i = 0, j = arr.length - 1 ; j>=i; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		int i = 0;
		for(int j = 0; j <= arr.length; ) {
			if(j == arr.length || arr[j] == ' ') {
				
				while(i < j-1) {
					char temp = arr[i];
					arr[i] = arr[j-1];
					arr[j-1] = temp;
					
					i++;
					j--;
				}
				
				i = j+1;
				j++;
			}else {
				j++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			sb.append(c);
		}
		return sb.toString();	
	}

}
