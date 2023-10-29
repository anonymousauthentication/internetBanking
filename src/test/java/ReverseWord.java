public class ReverseWord {
	public static void main(String args[]) {
		String ss = "this is selenium";
		reverseWord(ss);
	}

	public static void reverseWord(String ss) {
		System.out.println(ss);
		String[] wordSplit = ss.split(" ");
		for (int i = wordSplit.length - 1; i >= 0; i--) {
			System.out.print(wordSplit[i]+" ");
		}
	}
}
