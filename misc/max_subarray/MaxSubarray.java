/*

You are given an array of ints.
Find the max sum of consecutive elements.

input format:
The first line will be the number of test cases
In each test case, the first number N will be the length of the array
The second line in each test case will be the N numbers that are in the array

in:
2
6
-1 5 2 -2 1 -1
8
-1 5 -2 3 0 -1 2 1

out:
7
8

in:
8
3
8 -7 1000
3
8 -8 1000
3
8 -9 1000
5
1 1 1 -4 1000
5
3 -1 5 -20 2
5
-3 -5 -1 -2 -14
5
3 5 1 2 14
1
-13

out:
1001
1000
1000
1000
7
-1
25
-13

*/

import java.util.*;
import java.io.*;

class MaxSubarray {
	public static void main(String[] args) {
		runFast(System.in, System.out);
	}

	private static void runSlow(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int testCases = scan.nextInt();
		scan.nextLine(); 
		for (int currentCase = 0; currentCase < testCases; currentCase++) {
			int arrayLength = scan.nextInt();
			scan.nextLine();
			int[] array = new int[arrayLength];
			for (int i = 0; i < array.length; i++) {
				array[i] = scan.nextInt();
			}
			scan.nextLine();

			int bigSum = Integer.MIN_VALUE;
			for (int i = 0; i < array.length; i++) {
				int sum = 0;
				for (int j = i; j < array.length; j++) {
					sum += array[j];
					if (sum > bigSum) {
						bigSum = sum;
					}
				}
			}
			out.println(bigSum);
		}
	}

	//Kadane's algorithm
	private static void runFast(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int testCases = scan.nextInt();
		scan.nextLine();
		for (int currentCase = 0; currentCase < testCases; currentCase++) {
			int arrayLength = scan.nextInt();
			scan.nextLine();
			int[] array = new int[arrayLength];
			for (int i = 0; i < array.length; i++) {
				array[i] = scan.nextInt();
			}
			scan.nextLine();
			int sum = 0;
			int bigSum = Integer.MIN_VALUE;
			for (int i = 0; i < array.length; i++) {
				if (sum < 0) {
					sum = 0;
				}
				sum += array[i];
				if (bigSum < sum) {
					bigSum = sum;
				}
			}
			out.println(bigSum);
		}

	}

}











