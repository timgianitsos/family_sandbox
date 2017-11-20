import java.util.*;
import java.io.*;

class MiniMaxSum {
	public static final int SIZE = 5;

	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int[] array = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < array.length; i++) {
			
		}
	}
}