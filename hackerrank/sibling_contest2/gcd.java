import java.util.*;
import java.io.*;
class gcd {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		long a = scan.nextLong();
		long b = scan.nextLong();
		long c = scan.nextLong();
		long d = gcdEuclidIterativeFast(a, b);
		// return a != 0 && b != 0 ? run(Math.max(a, b) % Math.min(a, b), Math.min(a, b)) : Math.max(a, b);
		out.print(a/d + " ");
		out.print(b/d + " ");
		out.print(c/d);
		out.println();
	}

	static long gcdEuclidIterativeFast(long a, long b) {
		while (a != 0 && b != 0) {
			long difference = Math.max(a, b) % Math.min(a, b);
			a = Math.min(a, b);
			b = difference;
		}
		return Math.max(a, b);
	}
}