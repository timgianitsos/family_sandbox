import java.io.*;
import java.util.*;

class PlusMinus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		scan.close();
		double pos = 0;
		double neg = 0;
		double zero = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				pos++;
			}
			else if (array[i] < 0) {
				neg++;
			}
			else {
				assert array[i] == 0;
				zero++;
			}	
		}
		System.out.println(pos / n);
		System.out.println(neg / n);
		System.out.println(zero / n);
	}
}

/*
in:
6
-4 3 -9 0 4 1

out:
0.500000
0.333333
0.166667

*/