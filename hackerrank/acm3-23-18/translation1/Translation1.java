import java.util.*;
import java.io.*;
class Translation1 {
	public static void main(String args[]) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		String lang = scan.next();
		Map<String, String> words = new HashMap<>();
		for (int i = 0; i < n; i++) {
			words.put(scan.next(), scan.next());
		}
		String wordToFind = scan.next();
		scan.close();
		out.println("The word " + wordToFind + " translated into " + lang + " is " + words.get(wordToFind) + ".");

	} 

}