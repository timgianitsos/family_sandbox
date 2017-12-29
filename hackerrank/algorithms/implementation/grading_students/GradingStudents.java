import java.util.*;
import java.io.*;

class GradingStudent {
	public static final int FAILING = 40;

	public static void main(String args[]) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int students = scan.nextInt();
		int[] grades = new int[students];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = scan.nextInt(); 
		}
		scan.close();
		
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];
			int remander = grade % 5;
			int difference = 5 - remander;
			int nextMultiple = grade + difference;

			if ((grade + 2) < FAILING || (grade + 2) < nextMultiple) {
				out.println(grade);
			}
			else {
				out.println(nextMultiple);
			}
		
		}
	}
}
