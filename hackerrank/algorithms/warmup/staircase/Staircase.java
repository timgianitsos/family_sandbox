import java.io.*;
import java.util.*;

class Staircase {

	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		scan.close();
		for (int r = 0; r < n; r++) {
			int spaces = n - (r + 1);
			int symbols = r + 1;
			while (spaces > 0 ) {
				out.print(" ");
				spaces--;
			}
			while (symbols > 0) {
				out.print("#");
				symbols--;
			}
			out.println();
		}
	}
}
