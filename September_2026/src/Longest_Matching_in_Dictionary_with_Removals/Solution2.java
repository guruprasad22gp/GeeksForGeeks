package Longest_Matching_in_Dictionary_with_Removals;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public String findLongestWord(String s, List<String> d) {
		
		d.sort((a, b) -> {
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			return b.length() - a.length();
		});
		
		for(String str: d) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		
		for(String str: d) {
			if(isSubSequence(str, s)) {
				return str;
			}
		}
		
		return "";
	}
	
	private boolean isSubSequence(String s1, String s2) {
		int i = 0;
		int j = 0;
		
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;
			}
			
			j++;
		}
		
		return i == s1.length();
	}
	
	public static void main(String[] args) {
		List<String> d = new ArrayList<>(List.of("ale", "apple", "monkey", "plea"));
//		List<String> d = new ArrayList<>(List.of("w","a", "b", "c"));

		
		String s = "abpcplea";
		
		Solution2 sol2 = new Solution2();
		System.out.println("Output: " + sol2.findLongestWord(s, d));
	}
}
