import java.util.*;
import java.io.*;
class Reverse_ {
        public static void main(String[] args) {
            run(System.in, System.out);
        }

        private static void run(InputStream in, PrintStream out) {
            Scanner scan = new Scanner(in);
            int n = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < n; i++) {
            	String s = scan.nextLine();
            	for (int j = 0; j < s.length(); j++) {
            		char a = s.charAt(s.length() - (j + 1));
            		out.print(a);
            	}
            	out.println();
            }
            scan.close();
        }
}