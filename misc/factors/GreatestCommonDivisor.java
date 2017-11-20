/*
Given two numbers, return the greatest common factor (or divisor) between them

in:
25 35

out:
5

in:
10 30

out:
10
*/
import java.util.*;
import java.io.*;


class GreatestCommonDivisor {
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out){
		Scanner scan = new Scanner(in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.nextLine();
		scan.close();
		int divisor = 0;

		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				divisor = i;
			}
		}
		out.println(divisor);
	}
}
