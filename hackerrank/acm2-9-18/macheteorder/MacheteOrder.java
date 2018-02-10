import java.util.*;
import java.io.*;
class MacheteOrder {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	private static void run(InputStream in, PrintStream out) {
		Map<String, Integer> movieToEnjoyment = new HashMap<String, Integer>();
		Scanner scan = new Scanner(in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			movieToEnjoyment.put(scan.next(), scan.nextInt());
		}
		int product = 1;
		int m = scan.nextInt();
		for (int i = 0; i < m; i++) {
			int movieEnjoyment = movieToEnjoyment.get(scan.next());
			product = product * movieEnjoyment; 
		}
		scan.close();
		out.println(product);
		

	}
}

/*
6
phantommenace 4
attackofclones 1
revengeofsith 5
newhope 9
empirestrikesback 10
returnofjedi 7
3
newhope
empirestrikesback
returnofjedi
*/