/*
Given a fraction, simplify it. Numerator and denominator will be positive

in:
6 / 8

out:
3 / 4

in:
7 / 9

out:
7 / 9

*/
import java.util.*;
import java.io.*;

class SimplifyFraction {
	public static void main (String args[]) {
		run(System.in, System.out);
	}

	private static void run (InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int a = scan.nextInt();
		scan.next();
		int b = scan.nextInt();
		scan.nextLine();
		scan.close();

		int divisor = 0;
		int a1 = a;
		int b1 = b;
		while (a1 > 0 && b1 > 0) {
			int remainder = Math.max(a1, b1) % Math.min(a1, b1);
			a1 = Math.min(a1, b1);
			b1 = remainder;
			divisor = Math.max(a1, b1);
		}
		out.println(a / divisor + " / " + b / divisor);
	}
}