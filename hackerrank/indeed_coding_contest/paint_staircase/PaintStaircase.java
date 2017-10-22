import java.util.*;
import java.io.*;
class PaintStaircase {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int w = scan.nextInt(); 	
		int h = scan.nextInt();

		int middle = (h * 2) * w;
		int side = 0;
		for (int i = 1; i <= h; i++) {
			side += i;
		}
		int sides = side * 2;
		out.println(middle + sides);

	}
}