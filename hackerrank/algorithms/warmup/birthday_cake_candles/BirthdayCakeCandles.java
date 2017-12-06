import java.util.*;
import java.io.*;

class BirthdayCakeCandles {
	public static void main(String[] args) {
		run(System.in, System.out); 
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		int bigCandle = Integer.MIN_VALUE;
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > bigCandle) {
				bigCandle = arr[i];
				counter = 1;
			}
			
			else if (arr[i] == bigCandle) {
				counter++;
			}
		}
		out.println(counter);
	}
}