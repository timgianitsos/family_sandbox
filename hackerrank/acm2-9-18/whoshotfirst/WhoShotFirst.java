import java.util.*;
import java.io.*;
class WhoShotFirst {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		TreeMap<Integer, String> reactToName = new TreeMap<Integer, String>();
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			reactToName.put(scan.nextInt(), scan.next());
			scan.nextLine();
		}
		scan.close();
		out.println(reactToName.get(reactToName.firstKey()));

	}
}

// https://www.hackerrank.com/acm-2918