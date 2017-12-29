import java.util.*;
import java.io.*;

class GradingStudent {
	public static final FAILING = 40;

	public static void main(String args[]) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner();
		int students = scan.nextInt();
		int[] grades = new int[students];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = scan.nextInt(); 
		}
		scan.close();
		
		for (int i = 0; i < grades.length; i++) {
			if ((grades[i] + 2) < FAILING || (grades[i] + 2) < /*TODO if grade is less than 2 away from next multiple of five*/ ) {
			out.print(grades[i]);
			}
		
		}
	}
}
