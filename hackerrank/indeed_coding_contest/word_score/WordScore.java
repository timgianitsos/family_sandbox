import java.util.*;
import java.io.*;

class WordScore {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		String word = scan.nextLine();
		Set<Character> set = new HashSet<>();
		int score = 0;
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			if (!set.contains(current)) {
				set.add(current);
				score += (current % ('a' - 1));
			}
		}
		out.println(score);
	}


}