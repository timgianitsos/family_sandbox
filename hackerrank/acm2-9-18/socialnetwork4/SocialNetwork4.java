import java.util.*;
import java.io.*;

class SocialNetwork4 {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Map<String, Integer> nameToFreq = new LinkedHashMap<String, Integer>();
		Scanner scan = new Scanner(in);
		int N = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < N; i++) {
			String name = scan.nextLine();
			int counter = 0;
			for (int j = 0; j < name.length(); j++) {
				if (name.charAt(j) == '3' || name.charAt(j) == '4' || name.charAt(j) == '0' || name.charAt(j) == '1' || name.charAt(j) == '_') {
					counter++;
				}
				nameToFreq.put(name, counter);
			}
		}
		scan.close();

		int largest = Integer.MIN_VALUE;
		String nameAssociated = null;
		for (Map.Entry<String, Integer> pair : nameToFreq.entrySet()) {
			if (pair.getValue() > largest) {
				largest = pair.getValue();
				nameAssociated = pair.getKey();
			}
		}
		out.println(nameAssociated + " " + largest);
	}
}
/*
in:
3
4N4K1N
D4RTH_V4D3R
LUK3

out:
D4RTH_V4D3R 4
*/
	
