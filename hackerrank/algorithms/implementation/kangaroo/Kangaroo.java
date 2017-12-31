import java.util.*;
import java.io.*;

class Kangaroo {
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int x1 = scan.nextInt();
		int v1 = scan.nextInt();
		int x2 = scan.nextInt();
		int v2 = scan.nextInt();
		int currentX1 = x1;
		int currentX2 = x2;
		scan.close();

		if (v2 >= v1) {
			out.println("NO");
			return;
		}

		while (currentX1 < currentX2) {
			currentX1 += v1;
			currentX2 += v2;
		}
		out.println(currentX1 == currentX2 ? "YES" : "NO");

		




	}
}