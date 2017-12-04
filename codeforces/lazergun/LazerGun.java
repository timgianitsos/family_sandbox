import java.util.*;
import java.io.*;

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

		Set<Integer> slopes = new HashSet<>(); 

	}
}