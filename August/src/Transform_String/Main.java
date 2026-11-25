package Transform_String;

import java.util.Arrays;

public class Main {
	int transform(String s1, String s2) {
		int i = s1.length()-1;
		int j = s2.length()-1;
		int count = 0;
		
		if(s1.length() != s2.length()) {
			return -1;
		}
		
		char[] temp1 = s1.toCharArray();
		char[] temp2 = s2.toCharArray();
		
		Arrays.sort(temp1);
		Arrays.sort(temp2);
		
		String str1 = new String(temp1);
		String str2 = new String(temp2);
		
		if(!str1.equals(str2)) {
			System.out.println(str1 + " : " + str2);
			return -1;
		}
		
		while(i>= 0 && j>=0) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i--;
				j--;
				continue;
			} else {
				count++;
				i--;
			}
		}
		
		return count;
	}
	 
	public static void main(String[] args) {
		Main m = new Main();
		String s1 ="abd";
		String s2 = "bad";
		
		System.out.println("output: " + m.transform(s1, s2));
	}
}
