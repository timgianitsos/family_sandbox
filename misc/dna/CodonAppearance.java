/*
Given a string of DNA nucleotides letters A, G, C, and T, output YES if any codon appears n or more times, NO otherwise
A Codon is a sequence of 3 nucleotides.

input format:
The first line is the number of test cases
The second line is an int n which is the amount of times you need to see a codon to satisfy the condition
The third line is the dna sequence

in:
2
5
CATCATCATCATCATC
3
GTACGTAAGTA

out:
YES
YES

in:
1
4
CATCAT

out:
NO
*/

import java.util.*;
import java.io.*;

class CodonAppearance {

	static final int CODON_LEN = 3;
	static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};

	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int testCases = scan.nextInt();
		scan.nextLine();
		for (int testCase = 0; testCase < testCases; testCase++) {
			int n = scan.nextInt();
			scan.nextLine();
			String dna = scan.nextLine();
			Map<String, Integer> strToCount = new HashMap<>();
			boolean appearsN = false;
			for (int i = 0; i < dna.length() - (CODON_LEN - 1); i++) {
				String currentStr = dna.substring(i, i + CODON_LEN);
				int newFreq = strToCount.getOrDefault(currentStr, 0) + 1;
				if (newFreq >= n) {
					appearsN = true;
					break;
				}
				strToCount.put(currentStr, newFreq);
			}
			out.println(appearsN ? "YES" : "NO");
		}
	}	
}
