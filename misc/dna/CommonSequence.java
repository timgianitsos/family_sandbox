/*
Given a string of DNA nucleotides letters A, G, C, and T, output the Codons that appear n or more times.
A Codon is a sequence of 3 nucleotides.
The output must be in alphabetical order

input format:
The first line is the number of test cases
The second line is an int n which is the amount of times you need to see it in order to print it.
The third line is the dna sequence.

in:
2
5
CATCATCATCATCATC
3
GTACGTAAGTA

out:
ATC
CAT

GTA

*/
import java.util.*;

class CommonSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		scan.nextLine();
		for (int testCase = 0; testCase < testCases; testCase++) {
			int n = scan.nextInt();
			scan.nextLine();
			String dna = scan.nextLine();
			Map<String, Integer> strToCounter = new TreeMap<>();
			for (int i = 0; i < dna.length() - 2; i++) {
				String currentStr = dna.substring(i, i + 3);
				Integer currentFreq = strToCounter.get(currentStr);
				strToCounter.put(currentStr, (currentFreq != null ? currentFreq + 1 : 1));
			}

			for (Map.Entry<String, Integer> entry : strToCounter.entrySet()) {
				if (entry.getValue() >= n) {
					System.out.println(entry.getKey());
				}
			}
			System.out.println();
		}
		scan.close();
	}
	

}
