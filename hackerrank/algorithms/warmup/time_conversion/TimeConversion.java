import java.util.*;
import java.io.*;

class TimeConversion {
	private static final int ARMY_TIME_DIFFERENCE = 12;
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		String time = scan.nextLine();
		scan.close();

		String end2 = time.substring(time.length() - 2);
		int hour = Integer.parseInt(time.substring(0, 2));
		int mHour = hour;
		if (end2.equals("PM")) {
			mHour = hour + ARMY_TIME_DIFFERENCE;
		}
		String modified = time.substring(0, time.length() - 2);
		String armyTime = modified.substring(2);
		out.println(mHour + armyTime);
	}
}