import java.util.*;
import java.io.*;

class TimeConversion {
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		String time = scan.nextLine();
		String end2 = time.substring(time.length() - 2, time.length() - 1);
		if (end2.equals("AM")) {
			out.println(time.substring(0, time.length() - 1));
		}
	}
}