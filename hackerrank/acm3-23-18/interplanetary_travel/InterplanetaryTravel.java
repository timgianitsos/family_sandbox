import java.util.*;
import java.io.*;
class InterplanetaryTravel {
	public static void main(String args[]) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		for (int w = 0; w < n; w++) {

			String currentWord = scan.next();
			Map<Character, Integer> charToFreq = new HashMap<>();
			for (int i = 0; i < currentWord.length(); i++) {
				char currentLetter = currentWord.charAt(i);
				charToFreq.put(currentLetter, charToFreq.getOrDefault(currentLetter, 0) + 1);
			}

			//This only works because the values are unique
			TreeMap<Integer, Character> freqToChar = new TreeMap<>();
			for (Map.Entry<Character, Integer> pair: charToFreq.entrySet()) {
				freqToChar.put(pair.getValue(), pair.getKey());
			}

			StringBuilder martian = new StringBuilder();
			for (int key: freqToChar.descendingKeySet()) {
				char val = freqToChar.get(key);
				for (int i = 0; i < key; i++) {
					martian.append(val);
				}
			}
			out.println(martian.toString());
		}
	} 
}
