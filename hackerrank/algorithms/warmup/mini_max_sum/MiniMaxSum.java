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

		long maxSum = 0;
		long miniSum = 0;
		int bigInt = Integer.MIN_VALUE;
		int smallInt = Integer.MAX_VALUE;
		int bigIndex =  -1;
		int smallIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > bigInt) {
				bigInt = array[i];
				bigIndex = i;
			}
			if (array[i] < smallInt) {
				smallInt = array[i];
				smallIndex = i;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (i != smallIndex) {
				maxSum += array[i];
			}
			if (i != bigIndex) {
				miniSum += array[i];
			}
		}
		out.println(miniSum + " " + maxSum);

		/*
		Tim's solution
		long sum = 0;
		int big = Integer.MIN_VALUE;
		int small = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			big = big < array[i] ? array[i]: big;
			small = small > array[i] ? array[i]: small;
		}
		out.println((sum - big) + " " + (sum - small));
		*/
	}
}