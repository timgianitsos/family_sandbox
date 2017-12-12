import java.util.*;
import java.io.*;

/*
http://codeforces.com/problemset/problem/514/B?mobile=true
*/
class LazerGun {
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		int myX = scan.nextInt();
		int myY = scan.nextInt();
		int[] enemyX = new int[n]; 
		int[] enemyY = new int[n];
		for (int i = 0; i < n; i++) {
			enemyX[i] = scan.nextInt();
			enemyY[i] = scan.nextInt();
		}
		scan.nextLine();
		scan.close();

		Set<Fraction> slopes = new HashSet<>(); 

		for (int i = 0; i < enemyX.length; i++) {
			if ((myX - enemyX[i]) != 0) {
				Fraction fract = new Fraction((myY - enemyY[i]), (myX - enemyX[i]));
				slopes.add(fract);
			}
			else {
				slopes.add(null);
			}
		}
		out.println(slopes.size());
	}

	static class Fraction {
		private final int numerator;
		private final int denominator;

		Fraction(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
}

/*
in:
4 0 0
1 1
2 2
2 0
-1 -1

out:
2

in:
2 1 2
1 1
1 0

out:
1

in:
10 -4 -4
2 -4
2 0
-4 2
5 -4
-3 -5
1 4
-4 2
-3 5
0 -3
2 4

out:
8
*/

