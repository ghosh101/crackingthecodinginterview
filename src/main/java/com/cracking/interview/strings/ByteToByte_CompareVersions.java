package com.cracking.interview.strings;

//https://leetcode.com/problems/compare-version-numbers/
public class ByteToByte_CompareVersions {

	public static void main(String[] args) {
		String s1 = "01";
		String s2 = "1";

		int i = compareVersions(s1, s2);
		System.out.println(i);
	}

	private static int compareVersions(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");

		int x = 0;
		int y = 0;

		for(int i = 0, j = 0; ; i++, j++){
			if(i >= s1.length && j >= s2.length) break;
			else {
				if(i >= s1.length || j >= s2.length){
					if(i >= s1.length){
						x = 0;
					}else{
						x = Integer.valueOf(s1[i]);
					}

					if(j >= s2.length){
						y = 0;
					}else{
						y = Integer.valueOf(s2[j]);
					}
				}else{
					x = Integer.valueOf(s1[i]);
					y = Integer.valueOf(s2[j]);
				}
				
				if(x == y) continue;
				else if(x > y) return 1;
				else return -1;
			}
		}
		return 0;
	}

}
