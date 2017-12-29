import java.util.*;
import java.io.*;

class Kangaroo {
	public static void main(String[] args) {
		run(System.in, System.out);
	}
	private static void run(InputStream in, PrintStream out) {
		Scanner scan = new Scanner(in);
		int x1 = scan.nextInt();
		int v1 = scan.nextInt();
		int x2 = scan.nextInt();
		int v2 = scan.nextInt();
		scan.close();

		if ( v2 >= v1) {
			out.println("NO");
		}
		else if (v2 < v1 /* <- REMOVE */) { 
			out.println("NO");
		}
		else {
			out.println("YES");
		}




	}
}