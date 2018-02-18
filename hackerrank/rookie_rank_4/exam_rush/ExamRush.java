import java.util.*;
import java.io.*;

class ExamRush {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int chaps = scan.nextInt();
		int time = scan.nextInt();
		List<Integer> chapTimes = new ArrayList<>();
		for (int i = 0; i < chaps; i++) {
			chapTimes.add(scan.nextInt());
		}
		Collections.sort(chapTimes);

		int sum = 0;
		int counter = 0;
		for (int i = 0; sum <= time; i++) {
			sum += chapTimes.get(i);
			if (sum <= time) {
				counter++;
			}
		}
		out.println(counter);
	}
}
/*
in:
2 2
1
2

out:
1


in:
6 10
9
2
2
2
2
2

out:
5
*/
	
