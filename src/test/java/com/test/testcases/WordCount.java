package com.test.testcases;

public class WordCount {
	public static void main(String args[]) {
		String str = "ManoharKantJoshi";
		wordCount(str);
	}

	public static void wordCount(String atr) {
		int count = 1;
		for (int i = 0; i < atr.length(); i++) {
			for (int j = 1; j < atr.length(); j++) {
				if (atr.charAt(i) == atr.charAt(j)) {
					count++;

				}
			}
			
			System.out.println(atr.charAt(i) + " " + count);
			count = 0;
			atr = atr.replaceAll(atr.charAt(i) + "", "");
			
			if(atr.length()>0) {
				wordCount(atr);
				break;
			}
		}

	}
}
