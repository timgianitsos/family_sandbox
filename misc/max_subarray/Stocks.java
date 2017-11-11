/*

You are given an array of stock prices for as assett.
Find the best time to buy a stock, and the best time to sell
Each stock price is at minute intervals i.e. the seond price is 
one minute after the first. There will be at east two stock prices.

input:
The first line will be n, the number of prices in a day
The second line will be all the prices in a day

in:
5
5 15 3 9 14 12

out:
buy @ time 2
sell @ time 4

*/
import java.util.*;
import java.io.*;

class Stocks {
	public static void main(String[] args) {
		run(System.in, System.out);

	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		scan.nextLine();
		int[] stocks = new int[n];
		for (int i = 0; i < n; i++) {
			stocks[i] = scan.nextInt();
		}
		scan.nextLine();

		int currentDifference = 0;
		int bestSell = Integer.MIN_VALUE;
		int bestBuy = Integer.MAX_VALUE;
		int buy = -1;
		int sell = -1;
		for (int i = 0; i < (stocks.length - 1); i++) {
			currentDifference = stocks[i] - stocks[i + 1];
			if (currentDifference > bestSell) {
				bestSell = currentDifference;
				sell = i;			
			}
			if (currentDifference < bestBuy) {
				bestBuy = currentDifference;
				buy = i;
			}
		}
		out.println("buy @ time " + buy + "\nsell @ time " + sell);
	}
}



































