import java.util.Scanner;

class LetterFind {
	public static String TARGET = "wow it is windy and wet right now";

	public static void main(String args[]) {
		// Intro();
		// Scanner scan = new Scanner(System.in);
		// String TARGET = scan.next();
		char quant = 'w';

		LetterFind(TARGET, quant);
	}

	private static void LetterFind (String target, char quant) {
		int counter = 0;
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == quant) {
				counter++;
			}
		}
		System.out.println("\nThe letter " + quant + " appears " + counter + " time(s)\n");
	}
	private static void Intro () {
		System.out.print("\nEnter a sentence, then enter a word, ");
		System.out.println("this program will give you the amount of times the specified letter appears in the given sentence\n");
	}
}